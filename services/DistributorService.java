package services;

import entity.Barang;
import entity.Distributor;
import util.FileUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DistributorService {
    private List<Distributor> daftarDistributor;

    public DistributorService() {
        daftarDistributor = new ArrayList<>();
    }

    public List<Distributor> getDaftarDistributor() {
        return daftarDistributor;
    }

    public Distributor cariDistributor(String nama) {
        for (Distributor d : daftarDistributor) {
            if (d.getNama().equalsIgnoreCase(nama)) {
                return d;
            }
        }
        return null;
    }

    public List<Barang> getSemuaBarangKadaluarsa() {
        List<Barang> list = new ArrayList<>();
        for (Distributor d : daftarDistributor) {
            for (Barang b : d.getDaftarBarang()) {
                if (b.isKadaluarsa()) {
                    list.add(b);
                }
            }
        }
        return list;
    }

    public void periksaKadaluarsa(LocalDate hariIni) {
        for (Distributor d : daftarDistributor) {
            for (Barang b : d.getDaftarBarang()) {
                if (b.getTanggalKadaluarsa().isBefore(hariIni)) {
                    b.setKadaluarsa(true);
                }
            }
        }
    }

    public List<Barang> getSemuaBarang() {
        List<Barang> semua = new ArrayList<>();
        for (Distributor d : daftarDistributor) {
            semua.addAll(d.getDaftarBarang());
        }
        return semua;
    }

    public void hapusBarangById(int id) {
        for (Distributor d : daftarDistributor) {
            List<Barang> toRemove = new ArrayList<>();
            for (Barang b : d.getDaftarBarang()) {
                if (b.getId() == id) {
                    toRemove.add(b);
                }
            }
            for (Barang b : toRemove) {
                d.hapusBarang(b);
                FileUtil.hapusBarangDariFile(id);
            }
        }
    }

    public List<Barang> getSemuaBarangSortKadaluarsa() {
        List<Barang> sorted = getSemuaBarang();
        sorted.sort(Comparator.comparing(Barang::getTanggalKadaluarsa));
        return sorted;
    }
}


