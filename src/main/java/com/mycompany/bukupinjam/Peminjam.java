
package com.mycompany.bukupinjam;

import java.util.ArrayList;

/**
 *
 * @author kelompok 2
 */
public class Peminjam {
    private String nama;
    private ArrayList<String> riwayatPeminjaman;

    public Peminjam(String nama) {
        this.nama = nama;
        this.riwayatPeminjaman = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<String> getRiwayatPeminjaman() {
        return riwayatPeminjaman;
    }

    public void tambahRiwayat(String buku) {
        riwayatPeminjaman.add(buku);
    }

    public void hapusRiwayat(String buku) {
        riwayatPeminjaman.remove(buku);
    }
}
