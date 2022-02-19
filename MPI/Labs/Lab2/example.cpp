#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include "mpi.h"

void DataInitialization(double* x, int N){
	for (int i = 0; i < N; i++) {
		x[i] = i;
	}
}

int main(int argc, char* argv[])

{

	double x[100], TotalSum, ProcSum = 0.0;
	int ProcRank, ProcNum, N = 100;
	MPI_Status Status;

	// �������������
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &ProcNum);
	MPI_Comm_rank(MPI_COMM_WORLD, &ProcRank);

	// ���������� ������
	if (ProcRank == 0)
		DataInitialization(x, N);
	// �������� ������ �� ��� ��������
	MPI_Bcast(x, N, MPI_DOUBLE, 0, MPI_COMM_WORLD);

	// ���������� ��������� ����� �� ������ �� ���������
	// �� ������ �������� ����������� �������� ������� x �� i1 �� i2
	int k = N / ProcNum;
	int i1 = k * ProcRank;
	int i2 = k * (ProcRank + 1);
	if (ProcRank == ProcNum - 1)
		i2 = N;
	for (int i = i1; i < i2; i++)
		ProcSum = ProcSum + x[i];

	// ������ ��������� ���� �� �������� � ������ 0
	if (ProcRank == 0)
	{
		TotalSum = ProcSum;
		for (int i = 1; i < ProcNum; i++)
		{
			MPI_Recv(&ProcSum, 1, MPI_DOUBLE, MPI_ANY_SOURCE, 0, MPI_COMM_WORLD,
				&Status);
			TotalSum = TotalSum + ProcSum;
		}
	}
	else // ��� �������� �������� ���� ��������� �����
		MPI_Send(&ProcSum, 1, MPI_DOUBLE, 0, 0, MPI_COMM_WORLD);
	// ����� ����������
	if (ProcRank == 0)
		printf("\nTotal Sum = %10.2f", TotalSum);
	MPI_Finalize();
}