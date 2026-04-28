package driver;

import java.util.ArrayList;
import java.util.Scanner;
import model.Model3; 

public class Driver3 {
    private static ArrayList<Model3.Produk> katalog = new ArrayList<>();
    private static ArrayList<Model3.Transaksi> riwayat = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Inisialisasi Data
        katalog.add(new Model3.Produk("Kopi Susu Del", "Minuman", 15000));
        katalog.add(new Model3.Produk("Print BW", "Layanan", 1000));
        katalog.add(new Model3.Produk("Kaos IT Del", "Merchandise", 90000));

        System.out.println("=== KAFETARIA IT DEL ===");
        System.out.print("Username: ");
        String username = input.nextLine();

        while (true) {
            System.out.println("\n1. Daftar Produk\n2. Pembelian\n3. Keluar");
            System.out.print("Pilih menu: ");
            String pil = input.nextLine();

            if (pil.equals("1")) {
                tampilkanKatalog();
            } else if (pil.equals("2")) {
                beli(username);
            } else if (pil.equals("3")) {
                System.out.println("Bye " + username + "!");
                break;
            }
        }
    }

    private static void tampilkanKatalog() {
        System.out.println("\nDAFTAR PRODUK:");
        for (int i = 0; i < katalog.size(); i++) {
            Model3.Produk p = katalog.get(i);
            System.out.println((i + 1) + ". " + p.nama + " | Rp " + p.harga);
        }
    }

    private static void beli(String user) {
        tampilkanKatalog();
        System.out.print("Pilih nomor: ");
        int no = Integer.parseInt(input.nextLine()) - 1;
        
        System.out.print("Jumlah: ");
        int qty = Integer.parseInt(input.nextLine());
        if (qty <= 0) {
            System.out.println("Jumlah tidak valid!");
            return;
        }

        System.out.print("Kontak (WA): ");
        String hp = input.nextLine();

        Model3.Produk p = katalog.get(no);
        Model3.Transaksi t = new Model3.Transaksi(user, hp, p.nama, qty, p.harga * qty);
        riwayat.add(t);
        t.tampilkanRingkasan();
    }
}