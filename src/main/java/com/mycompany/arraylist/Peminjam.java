/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.arraylist;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author rayhan
 */
class Peminjam {
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