package driver;

import java.util.ArrayList;
import java.util.Scanner;
import model.Model2;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Model2> gudang = new ArrayList<>();

        System.out.print("Masukkan jumlah total data (N): ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nInput Data ke-" + (i + 1));
            System.out.print("Nama Barang    : ");
            String nama = sc.nextLine();
            System.out.print("Jumlah Stok    : ");
            int stok = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Kode Kategori  : ");
            String kategori = sc.nextLine();

            
            gudang.add(new Model2(nama, stok, kategori));
        }

        System.out.print("\nMasukkan Kode Kategori yang dicari: ");
        String targetKategori = sc.nextLine();
        int totalStokKategori = 0;

        for (Model2 item : gudang) {
            if (item.getKodeKategori().equalsIgnoreCase(targetKategori)) {
                totalStokKategori += item.getJumlahStok();
            }
        }

        System.out.println("Total Stok Kategori " + targetKategori + ": " + totalStokKategori);
        sc.close();
    }
}