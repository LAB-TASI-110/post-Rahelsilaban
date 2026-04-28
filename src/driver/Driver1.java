package driver;

import java.util.ArrayList;
import java.util.Scanner;
import model.Model1; 

public class Driver1 {
    public static void main(String[] args) {
        ArrayList<Model1> daftarKota = new ArrayList<>();
        daftarKota.add(new Model1("MDN", "Medan", 8000, "Dalam Pulau"));
        daftarKota.add(new Model1("BLG", "Balige", 5000, "Dalam Pulau"));
        daftarKota.add(new Model1("JKT", "Jakarta", 12000, "Luar Pulau"));
        daftarKota.add(new Model1("SBY", "Surabaya", 13000, "Luar Pulau"));

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String inputKode = sc.next();
            if (inputKode.equalsIgnoreCase("END")) break;

            if (sc.hasNextDouble()) {
                double beratButet = sc.nextDouble();
                double beratUcok = 1.5 * beratButet;
                double totalBerat = beratButet + beratUcok;

                Model1 tujuan = null;
                for (Model1 m : daftarKota) {
                    if (m.kode.equalsIgnoreCase(inputKode)) {
                        tujuan = m;
                        break;
                    }
                }

                if (tujuan != null) {
                    tampilkanOutput(tujuan, beratButet, beratUcok, totalBerat);
                }
            }
        }
        sc.close();
    }

    private static void tampilkanOutput(Model1 m, double bButet, double bUcok, double totalB) {
        double biayaAwal = totalB * m.harga;
        double biayaAkhir = biayaAwal;
        String promo = "-";

        // Logika Promo
        if (totalB > 10) {
            biayaAkhir *= 0.9;
            promo = "Diskon 10%";
        }

        if (m.wilayah.equalsIgnoreCase("Luar Pulau")) {
            if (promo.equals("-")) promo = "Asuransi Gratis";
            else promo += " & Asuransi Gratis";
        }

        
        System.out.println("====================================");
        System.out.printf("Kota Tujuan      : %s\n", m.nama);
        System.out.printf("Berat Butet      : %.1f kg\n", bButet);
        System.out.printf("Berat Ucok       : %.1f kg\n", bUcok);
        System.out.printf("Total Berat      : %.1f kg\n", totalB);
        System.out.printf("Total Ongkir     : Rp %.0f\n", biayaAkhir);
        System.out.printf("Promo            : %s\n", promo);
        System.out.println("====================================\n");
    }
}