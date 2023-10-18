package Matrix;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris matriks: ");
        int rows = input.nextInt();
        System.out.print("Masukkan jumlah kolom matriks: ");
        int cols = input.nextInt();

        Matrix matrix1 = new Matrix(rows, cols);
        Matrix matrix2 = new Matrix(rows, cols);

        System.out.println("Masukkan matriks pertama:");
        matrix1.inputMatrix();

        System.out.println("Matriks Pertama:");
        matrix1.printMatrix();

        System.out.println("Hasil transposisi matriks pertama:");
        Matrix transposedMatrix = matrix1.transpose();
        transposedMatrix.printMatrix();

        System.out.println("Masukkan matriks kedua:");
        matrix2.inputMatrix();

        System.out.println("Matriks Kedua:");
        matrix2.printMatrix();

        Matrix resultAddition = matrix1.add(matrix2);
        if (resultAddition != null) {
            System.out.println("Hasil penjumlahan matriks:");
            resultAddition.printMatrix();
        }

        Matrix resultSubtraction = matrix1.subtract(matrix2);
        if (resultSubtraction != null) {
            System.out.println("Hasil pengurangan matriks:");
            resultSubtraction.printMatrix();
        }

        // Implementasi operasi perkalian matriks

        System.out.println("Masukkan matriks yang ingin diinversi:");
        Matrix matrixToInverse = new Matrix(rows, cols);
        matrixToInverse.inputMatrix();

        Matrix resultInverse = matrixToInverse.inverse();
        if (resultInverse != null) {
            System.out.println("Hasil inversi matriks:");
            resultInverse.printMatrix();
        }
    }
}