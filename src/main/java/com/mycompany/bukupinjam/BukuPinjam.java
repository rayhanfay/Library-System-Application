
package com.mycompany.bukupinjam;
import com.mycompany.bukupinjam.Buku;
import com.mycompany.bukupinjam.Peminjam;
import java.util.ArrayList;
import java.util.Scanner;

//@author kelompok 2
 
public class BukuPinjam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        ArrayList<Peminjam> daftarPeminjam = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Perpustakaan Kelompok 2 =====");
            System.out.println("1. Tambah buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Informasi Buku");
            System.out.println("6. Menambah Peminjam");
            System.out.println("7. Mencari Peminjam");
            System.out.println("8. Menghapus Peminjam");
            System.out.println("9. History Peminjaman");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan penerbit buku : ");
                    String penerbit = input.nextLine();
                    System.out.print("Masukkan pengarang buku : ");
                    String pengarang = input.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int tahunTerbit = input.nextInt();
                    input.nextLine();

                    Buku buku = new Buku(judul, penerbit, pengarang, tahunTerbit);
                    daftarBuku.add(buku);
                    System.out.println("Buku ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan nama peminjam : ");
                    String namaPeminjam = input.nextLine();
                    System.out.print("Masukkan judul buku yang akan dipinjam : ");
                    String judulPinjam = input.nextLine();

                    Buku bukuPinjam = null;
                    for (Buku b : daftarBuku) {
                        if (b.getJudul().equalsIgnoreCase(judulPinjam) 
                            && b.isTersedia()) {
                            bukuPinjam = b;
                            break;
                        }
                    }

                    if (bukuPinjam != null) {
                        bukuPinjam.pinjamBuku();
                        Peminjam peminjam = null;
                        for (Peminjam p : daftarPeminjam) {
                            if (p.getNama().equalsIgnoreCase(namaPeminjam)) {
                                peminjam = p;
                                break;
                            }
                        }
                        if (peminjam == null) {
                            peminjam = new Peminjam(namaPeminjam);
                            daftarPeminjam.add(peminjam);
                        }
                        peminjam.tambahRiwayat(judulPinjam);
                        System.out.println("Buku berhasil dipinjam oleh " + namaPeminjam + ".");
                    } else {
                        System.out.println("Buku tidak tersedia.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = input.nextLine();

                    Buku bukuHapus = null;
                    for (Buku b : daftarBuku) {
                        if (b.getJudul().equalsIgnoreCase(judulHapus)) {
                            bukuHapus = b;
                            break;
                        }
                    }

                    if (bukuHapus != null) {
                        if (bukuHapus.isTersedia()) {
                            daftarBuku.remove(bukuHapus);
                            System.out.println("Buku dihapus.");
                        } else {
                            System.out.println("Buku sedang dipinjam, tidak dapat dihapus.");
                        }
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan judul buku yang akan dicari: ");
                    String judulCari = input.nextLine();

                    for (Buku b : daftarBuku) {
                        if (b.getJudul().equalsIgnoreCase(judulCari)) {
                            System.out.println("Buku ditemukan:");
                            System.out.println(b.toString());
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Daftar Buku:");
                    for (Buku b : daftarBuku) {
                        System.out.println(b.toString());
                    }
                    break;

                case 6:
                    System.out.print("Masukkan nama peminjam: ");
                    String namaPeminjamBaru = input.nextLine();
                    Peminjam peminjamBaru = new Peminjam(namaPeminjamBaru);
                    daftarPeminjam.add(peminjamBaru);
                    System.out.println("Peminjam baru ditambahkan.");
                    break;

                case 7:
                    System.out.print("Masukkan nama peminjam yang akan dicari: ");
                    String namaCari = input.nextLine();

                    for (Peminjam p : daftarPeminjam) {
                        if (p.getNama().equalsIgnoreCase(namaCari)) {
                            System.out.println("Peminjam ditemukan:");
                            System.out.println("Nama: " + p.getNama());
                            System.out.println("Riwayat Peminjaman:");
                            for (String bukuPeminjam : p.getRiwayatPeminjaman()) {
                                System.out.println("- " + bukuPeminjam);
                            }
                            break;
                        }
                    }
                    break;

                case 8:
                    System.out.print("Masukkan nama peminjam yang akan dihapus : ");
                    String namaHapus = input.nextLine();

                    Peminjam peminjamHapus = null;
                    for (Peminjam p : daftarPeminjam) {
                        if (p.getNama().equalsIgnoreCase(namaHapus)) {
                            peminjamHapus = p;
                            break;
                        }
                    }

                    if (peminjamHapus != null) {
                        daftarPeminjam.remove(peminjamHapus);
                        System.out.println("Peminjam dihapus.");
                    } else {
                        System.out.println("Peminjam tidak ditemukan.");
                    }
                    break;

                case 9:
                    System.out.print("Masukkan nama peminjam untuk melihat riwayat : ");
                    String namaRiwayat = input.nextLine();

                    Peminjam peminjamRiwayat = null;
                    for (Peminjam p : daftarPeminjam) {
                        if (p.getNama().equalsIgnoreCase(namaRiwayat)) {
                            peminjamRiwayat = p;
                            break;
                        }
                    }

                    if (peminjamRiwayat != null) {
                        System.out.println("Riwayat Peminjaman untuk " + namaRiwayat + ":");
                        for (String bukuPeminjam : peminjamRiwayat.getRiwayatPeminjaman()) {
                            System.out.println("- " + bukuPeminjam);
                        }
                    } else {
                        System.out.println("Peminjam tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Non Valid.");
                    break;
            }
        }
    }
}
