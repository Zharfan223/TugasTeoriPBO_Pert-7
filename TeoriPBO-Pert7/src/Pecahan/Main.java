package Pecahan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan pembilang pertama: ");
        int pembilang1 = input.nextInt();
        System.out.print("Masukkan penyebut pertama: ");
        int penyebut1 = input.nextInt();

        System.out.print("Masukkan pembilang kedua: ");
        int pembilang2 = input.nextInt();
        System.out.print("Masukkan penyebut kedua: ");
        int penyebut2 = input.nextInt();

        Pecahan Pecahan1 = new Pecahan(pembilang1, penyebut1);
        Pecahan Pecahan2 = new Pecahan(pembilang2, penyebut2);

        Pecahan hasilTambah = Pecahan1.tambah(Pecahan2);
        Pecahan hasilKurang = Pecahan1.kurang(Pecahan2);
        Pecahan hasilKali = Pecahan1.kali(Pecahan2);
        Pecahan hasilBagi = Pecahan1.bagi(Pecahan2);

        System.out.println("Hasil Penambahan: " + hasilTambah);
        System.out.println("Hasil Pengurangan: " + hasilKurang);
        System.out.println("Hasil Perkalian: " + hasilKali);
        System.out.println("Hasil Pembagian: " + hasilBagi);

        input.close();
    }
}
