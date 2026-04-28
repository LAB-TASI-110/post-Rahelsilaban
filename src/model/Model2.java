package model;

public class Model2 {
    private String namaBarang;
    private int jumlahStok;
    private String kodeKategori;

    public Model2(String namaBarang, int jumlahStok, String kodeKategori) {
        this.namaBarang = namaBarang;
        this.jumlahStok = jumlahStok;
        this.kodeKategori = kodeKategori;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }
}