package entity;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    private String nama;
    private List<Barang> daftarBarang;

    public Distributor(String nama) {
        this.nama = nama;
        this.daftarBarang = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    @Override
    public String toString() {
        return nama;
    }
}