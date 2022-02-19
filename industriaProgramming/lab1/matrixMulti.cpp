#include <iostream>
#include <cstdlib>
#include <ctime>

using std::cin;
using std::cout;
using std::endl;

int inputInt(int min) {
	int number;
	do {
		cin >> number;
	} while (number < min);
	return number;
}

int inputInt(int min, int max) {
	int number;
	do {
		cin >> number;
	} while (number < min || number > max);
	return number;
}

void enterSizeMatrix(int* rows, int* cols) {
	cout << "Введите количество строк\n";
	*rows = inputInt(1);
	cout << "Введите количество столбцов\n";
	*cols = inputInt(1);
}

int** createMatrix(int rows, int cols) {
	int** matrix = new int* [rows];
	for (int i = 0; i < rows; i++) {
		matrix[i] = new int[cols];
	}
	return matrix;
}

int** creatreZeroMatrix(int rows, int cols) {
	int** matrix = createMatrix(rows, cols);
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++)
			matrix[i][j] = 0;
	}
	return matrix;
}

void fillMatrix(int** matrix, int rows, int cols) {
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			cin >> matrix[i][j];
}

void fillMatrixRand(int** matrix, int rows, int cols) {
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			matrix[i][j] = rand() % 10;
}

void deleteMatrix(int** matrix, int rows) {
	for (int i = 0; i < rows; i++) {
		delete[] matrix[i];
	}
	delete[] matrix;
}

int** matrixReduction(int** matrix, int rows, int cols, int sizeNewMatrix) {
	int** matrix_resize = creatreZeroMatrix(sizeNewMatrix, sizeNewMatrix);
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			matrix_resize[i][j] = matrix[i][j];
	deleteMatrix(matrix, rows);
	return matrix_resize;
}

void printMatrix(int** matrix, int rows, int cols) {
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << endl;
	}
}

int findNewSize(int rowsLeft, int colsLeft, int rowsRight, int colsRight) {
	int newSize = 2;
	while (newSize <= rowsLeft || newSize <= rowsRight || newSize <= colsLeft || newSize <= colsRight) {
		newSize *= 2;
	}
	return newSize;
}

int** matrixMultiplicationStrassen(int** matrixLeft, int** matrixRight, int sizeMatrix) {
	int** matrixResult = createMatrix(sizeMatrix, sizeMatrix);

	int** interimMatrixD = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixD1 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixD2 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixH1 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixH2 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixV1 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);
	int** interimMatrixV2 = creatreZeroMatrix(sizeMatrix / 2, sizeMatrix / 2);

	for (int i = 0; i < sizeMatrix / 2; i++) {
		for (int j = 0; j < sizeMatrix / 2; j++) {
			for (int z = 0; z < sizeMatrix / 2; z++) {
				int elementLeftPatrs11 = matrixLeft[i][z];
				int elementLeftPatrs12 = matrixLeft[i][z + sizeMatrix / 2];
				int elementLeftPatrs21 = matrixLeft[i + sizeMatrix / 2][z];
				int elementLeftPatrs22 = matrixLeft[i + sizeMatrix / 2][z + sizeMatrix / 2];

				int elementRightPatrs11 = matrixRight[z][j];
				int elementRightPatrs12 = matrixRight[z][j + sizeMatrix / 2];
				int elementRightPatrs21 = matrixRight[z + sizeMatrix / 2][j];
				int elementRightPatrs22 = matrixRight[z + sizeMatrix / 2][j + sizeMatrix / 2];

				interimMatrixD[i][j] += (elementLeftPatrs11 + elementLeftPatrs22) * (elementRightPatrs11 + elementRightPatrs22);
				interimMatrixD1[i][j] += (elementLeftPatrs12 - elementLeftPatrs22) * (elementRightPatrs21 + elementRightPatrs22);
				interimMatrixD2[i][j] += (elementLeftPatrs21 - elementLeftPatrs11) * (elementRightPatrs11 + elementRightPatrs12);
				interimMatrixH1[i][j] += (elementLeftPatrs11 + elementLeftPatrs12) * elementRightPatrs22;
				interimMatrixH2[i][j] += (elementLeftPatrs21 + elementLeftPatrs22) * elementRightPatrs11;
				interimMatrixV1[i][j] += elementLeftPatrs22 * (elementRightPatrs21 - elementRightPatrs11);
				interimMatrixV2[i][j] += elementLeftPatrs11 * (elementRightPatrs12 - elementRightPatrs22);
			}
		}
	}
	for (int i = 0; i < sizeMatrix / 2; i++) {
		for (int j = 0; j < sizeMatrix / 2; j++) {
			matrixResult[i][j] = interimMatrixD[i][j] + interimMatrixD1[i][j] - interimMatrixH1[i][j] + interimMatrixV1[i][j];
			matrixResult[i][j + sizeMatrix / 2] = interimMatrixH1[i][j] + interimMatrixV2[i][j];
			matrixResult[i + sizeMatrix / 2][j] = interimMatrixH2[i][j] + interimMatrixV1[i][j];
			matrixResult[i + sizeMatrix / 2][j + sizeMatrix / 2] = interimMatrixD[i][j] + interimMatrixD2[i][j] - interimMatrixH2[i][j] + interimMatrixV2[i][j];
		}
	}

	deleteMatrix(interimMatrixD, sizeMatrix / 2);
	deleteMatrix(interimMatrixD1, sizeMatrix / 2);
	deleteMatrix(interimMatrixD2, sizeMatrix / 2);
	deleteMatrix(interimMatrixH1, sizeMatrix / 2);
	deleteMatrix(interimMatrixH2, sizeMatrix / 2);
	deleteMatrix(interimMatrixV1, sizeMatrix / 2);
	deleteMatrix(interimMatrixV2, sizeMatrix / 2);

	return matrixResult;
}


int main()
{
	srand(time(NULL));
	system("chcp 1251");

	int rowsLeft, colsLeft, rowsRight, colsRight, matrixNewSize;

	cout << "Вас приветствует программа" << endl <<
		"быстрого перемножения матриц методом Штрассена\n\n";
	cout << "Введите размеры левой матрицы\n";
	enterSizeMatrix(&rowsLeft, &colsLeft);
	cout << "Введите размеры правой матрицы\n";
	enterSizeMatrix(&rowsRight, &colsRight);

	int** matrixLeft = createMatrix(rowsLeft, colsLeft);
	int** matrixRight = createMatrix(rowsRight, colsRight);

	cout << "Выберите способ заполнения матриц\n" <<
		"1 - Вручную \n2 - Случайным образом\n";
	switch (inputInt(1, 2))
	{
	case 1:
		fillMatrix(matrixLeft, rowsLeft, colsLeft);
		fillMatrix(matrixRight, rowsRight, colsRight);
		break;
	case 2:
		fillMatrixRand(matrixLeft, rowsLeft, colsLeft);
		fillMatrixRand(matrixRight, rowsRight, colsRight);
		break;
	}

	cout << "\nМатрица 1\n\n";
	printMatrix(matrixLeft, rowsLeft, colsLeft);
	cout << "\nМатрица 2\n\n";
	printMatrix(matrixRight, rowsRight, colsRight);

	matrixNewSize = findNewSize(rowsLeft, colsLeft, rowsRight, colsRight);

	matrixLeft = matrixReduction(matrixLeft, rowsLeft, colsLeft, matrixNewSize);
	matrixRight = matrixReduction(matrixRight, rowsRight, colsRight, matrixNewSize);

	cout << "Приведенные матрицы\n";
	cout << "\nМатрица 1\n\n";
	printMatrix(matrixLeft, matrixNewSize, matrixNewSize);
	cout << "\nМатрица 2\n\n";
	printMatrix(matrixRight, matrixNewSize, matrixNewSize);

	int** matrixResult = matrixMultiplicationStrassen(matrixLeft, matrixRight, matrixNewSize);

	cout << "\nРезультирующая матрица\n\n";
	printMatrix(matrixResult, rowsLeft, colsRight);

	deleteMatrix(matrixLeft, matrixNewSize);
	deleteMatrix(matrixRight, matrixNewSize);
	deleteMatrix(matrixResult, matrixNewSize);

	system("pause");
}