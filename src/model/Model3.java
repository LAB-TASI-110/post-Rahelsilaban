package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model3 {


    public static class Produk {
        public String nama;
        public String kategori;
        public double harga;

        public Produk(String nama, String kategori, double harga) {
            this.nama = nama;
            this.kategori = kategori;
            this.harga = harga;
        }
    }

    public static class Transaksi {
        public String pelanggan, kontak, item;
        public int jumlah;
        public double total;
        public String waktu;

        public Transaksi(String pelanggan, String kontak, String item, int jumlah, double total) {
            this.pelanggan = pelanggan;
            this.kontak = kontak;
            this.item = item;
            this.jumlah = jumlah;
            this.total = total;
            this.waktu = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        }

        public void tampilkanRingkasan() {
            System.out.println("\n--- RINGKASAN TRANSAKSI ---");
            System.out.println("Waktu   : " + waktu);
            System.out.println("Item    : " + item + " (x" + jumlah + ")");
            System.out.printf("Total   : Rp %,.0f\n", total);
            System.out.println("---------------------------");
        }
    }
}