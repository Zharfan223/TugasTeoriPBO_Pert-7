package Matrix;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan elemen matriks (baris per baris, elemen dipisahkan oleh spasi):");
        for (int i = 0; i < rows; i++) {
            String[] rowElements = scanner.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                data[i][j] = Double.parseDouble(rowElements[j]);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            System.out.print("[ ");
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j]);
                if (j < columns - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            System.out.println("Operasi penjumlahan tidak dapat dilakukan. Matriks harus memiliki dimensi yang sama.");
            return null;
        }

        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            System.out.println("Operasi pengurangan tidak dapat dilakukan. Matriks harus memiliki dimensi yang sama.");
            return null;
        }

        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            System.out.println("Operasi perkalian tidak dapat dilakukan. Jumlah kolom matriks pertama harus sama dengan jumlah baris matriks kedua.");
            return null;
        }

        Matrix result = new Matrix(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }

        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(columns, rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                result.data[i][j] = this.data[j][i];
            }
        }
        return result;
    }

    public Matrix inverse() {
        if (rows != columns) {
            System.out.println("Matriks bukan matriks persegi, invers tidak dapat dihitung.");
            return null;
        }

        int n = rows;
        Matrix augmentedMatrix = new Matrix(n, 2 * n);

        // Salin matriks asli ke matriks augmented
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix.data[i][j] = data[i][j];
            }
            augmentedMatrix.data[i][n + i] = 1; // Matriks identitas di samping kanan
        }

        // Terapkan metode eliminasi Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix.data[i][i];
            if (pivot == 0) {
                System.out.println("Matriks tidak memiliki invers karena determinannya nol.");
                return null;
            }

            // Skala baris saat ini untuk membuat elemen diagonal menjadi 1
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix.data[i][j] /= pivot;
            }

            // Eliminasi elemen di bawah diagonal
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix.data[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix.data[k][j] -= factor * augmentedMatrix.data[i][j];
                    }
                }
            }
        }

        // Ekstrak matriks invers dari matriks augmented
        Matrix inverseMatrix = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix.data[i][j] = augmentedMatrix.data[i][n + j];
            }
        }

        return inverseMatrix;
    }
}