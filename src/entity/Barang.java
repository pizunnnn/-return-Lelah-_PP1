package entity;

import java.time.LocalDate;

public class Barang {
    private int id;
    private String nama;
    private boolean kadaluarsa;
    private Distributor distributor;
    private LocalDate tanggalKadaluarsa;

    public Barang(int id, String nama, Distributor distributor, LocalDate tanggalKadaluarsa) {
        this.id = id;
        this.nama = nama;
        this.kadaluarsa = false;
        this.distributor = distributor;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public boolean isKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(boolean kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public LocalDate getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    @Override
    public String toString() {
        return nama + " (ID: " + id + ", Kadaluwarsa: " + tanggalKadaluarsa + ")";
    }
}