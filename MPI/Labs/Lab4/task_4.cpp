#include <iostream>
#include <cstdlib>
#include <cmath>
#include <mpi.h>
#include <cstddef>

constexpr int DOUBLE_MAX = 10;

struct CustomData {
	int size;
	double values[DOUBLE_MAX];
};

int main(int argc, char** argv) {

	int procRunk, procNum;

	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &procNum);
	MPI_Comm_rank(MPI_COMM_WORLD, &procRunk);

	constexpr int n_structure_per_process = 5;

	srand(procRunk * 10);

	CustomData data[n_structure_per_process];

	// Generating the data
	for (int i = 0; i < n_structure_per_process; ++i) {
		// Terrible way of generating random numbers, don't reproduce this at home
		data[i].size = rand() % DOUBLE_MAX + 1;
		for (int j = 0; j < DOUBLE_MAX; ++j)
			data[i].values[j] = (j < data[i].size ? (double)rand() / (double)RAND_MAX : 0.0);
	}

	// 1- Here, create all the properties to call MPI_Type_create_struct
	MPI_Aint displacements[2] = {};
	int block_lengths[2] = {};
	MPI_Datatype types[2] = {};
	MPI_Datatype custom_dt;
	CustomData* gathered_data = nullptr;

	if (procRunk == 0)
		gathered_data = new CustomData[n_structure_per_process * procNum];

	MPI_Gather(data, n_structure_per_process, custom_dt,
		gathered_data, n_structure_per_process, custom_dt, 0, MPI_COMM_WORLD);

	if (procRunk == 0) {
		for (int i = 0; i < procNum; ++i) {
			for (int j = 0; j < n_structure_per_process; ++j) {
				int data_id = i * n_structure_per_process + j;

				std::cout << "Data structure " << data_id << " : [";
				int N = gathered_data[data_id].size;

				for (int k = 0; k < N; ++k) {
					std::cout << gathered_data[data_id].values[k] << (k == N - 1 ? "]" : "; ");
				}
				std::cout << std::endl;
			}
		}
	}

	MPI_Finalize();
	return 0;
}
