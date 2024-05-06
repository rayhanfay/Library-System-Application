
package com.mycompany.bukupinjam;

/**
 *
 * @author kelompok 2
 */
public class Buku {
    private String judul;
    private String penerbit;
    private String pengarang;
    private int tahunTerbit;
    private boolean tersedia;

    public Buku(String judul, String penerbit, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.penerbit = penerbit;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void pinjamBuku() {
        tersedia = false;
    }

    public void kembalikanBuku() {
        tersedia = true;
    }

    public String toString() {
        return "Judul: " + judul + "\nPenerbit: " + penerbit + "\nPengarang: " + pengarang
                + "\nTahun Terbit: " + tahunTerbit + "\nStatus: " + (tersedia ? "Tersedia" : "Dipinjam");
    }
}
