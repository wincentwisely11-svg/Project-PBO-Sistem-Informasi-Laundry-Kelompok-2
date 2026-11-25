package dao;

import java.sql.*;
import java.util.Scanner;

public class customerdao {

    // ===== Menampilkan semua pelanggan =====
    public static void tampilDataPelanggan() {
        System.out.println("| id_pelanggan | nama | no_telepon | alamat |");

        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM sistemlaundrydb.pelanggan ORDER BY id_pelanggan");
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    "| " + rs.getString("id_pelanggan") +
                    " | " + rs.getString("nama") +
                    " | " + rs.getString("no_telepon") +
                    " | " + rs.getString("alamat") + " |"
                );
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mencari pelanggan berdasarkan ID =====
    public static void cariPelangganById(String id_pelanggan) {
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM sistemlaundrydb.pelanggan WHERE id_pelanggan = ?")) {

            ps.setString(1, id_pelanggan);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID Pelanggan : " + rs.getString("id_pelanggan"));
                System.out.println("Nama         : " + rs.getString("nama"));
                System.out.println("No. Telepon  : " + rs.getString("no_telepon"));
                System.out.println("Alamat       : " + rs.getString("alamat"));
            } else {
                System.out.println("Pelanggan dengan ID " + id_pelanggan + " tidak ditemukan.");
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menambah pelanggan =====
    public static void tambahPelanggan(
        String id_pelanggan,
        String nama,
        String no_telepon,
        String alamat) {

        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO sistemlaundrydb.pelanggan (id_pelanggan, nama, no_telepon, alamat) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, id_pelanggan);
            ps.setString(2, nama);
            ps.setString(3, no_telepon);
            ps.setString(4, alamat);

            int affected = ps.executeUpdate();

            if (affected > 0) {
                System.out.println("Pelanggan berhasil ditambahkan.");
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mengubah nama pelanggan saja =====
    public static void updateNamaPelanggan(String id_pelanggan, String nama) {
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "UPDATE sistemlaundrydb.pelanggan SET nama = ? WHERE id_pelanggan = ?")) {

            ps.setString(1, nama);
            ps.setString(2, id_pelanggan);

            int affected = ps.executeUpdate();

            if (affected > 0) {
                System.out.println("Nama pelanggan berhasil diubah.");
            } else {
                System.out.println("Pelanggan dengan ID " + id_pelanggan + " tidak ditemukan.");
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mengubah semua data pelanggan =====
    public static void updatePelanggan(
        String id_pelanggan,
        String nama,
        String no_telepon,
        String alamat) {

        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "UPDATE sistemlaundrydb.pelanggan SET nama = ?, no_telepon = ?, alamat = ? WHERE id_pelanggan = ?")) {

            ps.setString(1, nama);
            ps.setString(2, no_telepon);
            ps.setString(3, alamat);
            ps.setString(4, id_pelanggan);

            int affected = ps.executeUpdate();

            if (affected > 0) {
                System.out.println("Data pelanggan berhasil diubah.");
            } else {
                System.out.println("Pelanggan dengan ID " + id_pelanggan + " tidak ditemukan.");
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menghapus pelanggan =====
    public static void hapusPelanggan(String id_pelanggan) {
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM sistemlaundrydb.pelanggan WHERE id_pelanggan = ?")) {

            ps.setString(1, id_pelanggan);

            int affected = ps.executeUpdate();

            if (affected > 0) {
                System.out.println("Pelanggan berhasil dihapus.");
            } else {
                System.out.println("Pelanggan dengan ID " + id_pelanggan + " tidak ditemukan.");
            }

        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== SUBMENU DATA PELANGGAN =====
    public static void menuPelanggan(Scanner input) {
        int pilihan;

        do {
            System.out.println("---------- DATA PELANGGAN ----------");
            System.out.println("1. Tampilkan semua pelanggan");
            System.out.println("2. Cari pelanggan berdasarkan ID");
            System.out.println("3. Tambah pelanggan");
            System.out.println("4. Ubah data pelanggan");
            System.out.println("5. Hapus pelanggan");
            System.out.println("0. Kembali ke menu utama");
            System.out.println("------------------------------------");
            System.out.print("Pilih : ");

            pilihan = input.nextInt();
            input.nextLine();

            System.out.println();

            switch (pilihan) {

                case 1:
                    tampilDataPelanggan();
                    break;

                case 2:
                    System.out.print("ID pelanggan : ");
                    String idCari = input.nextLine();

                    cariPelangganById(idCari);
                    break;

                case 3:
                    System.out.print("ID pelanggan : ");
                    String idBaru = input.nextLine();

                    System.out.print("Nama         : ");
                    String namaBaru = input.nextLine();

                    System.out.print("No. Telepon  : ");
                    String teleponBaru = input.nextLine();

                    System.out.print("Alamat       : ");
                    String alamatBaru = input.nextLine();

                    tambahPelanggan(idBaru, namaBaru, teleponBaru, alamatBaru);
                    break;

                case 4:
                    System.out.print("ID pelanggan yang diubah : ");
                    String idUbah = input.nextLine();

                    System.out.print("Nama baru                : ");
                    String namaUbah = input.nextLine();

                    System.out.print("No. Telepon baru         : ");
                    String teleponUbah = input.nextLine();

                    System.out.print("Alamat baru              : ");
                    String alamatUbah = input.nextLine();

                    updatePelanggan(idUbah, namaUbah, teleponUbah, alamatUbah);
                    break;

                case 5:
                    System.out.print("ID pelanggan yang dihapus : ");
                    String idHapus = input.nextLine();

                    hapusPelanggan(idHapus);
                    break;

                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }

            System.out.println();

        } while (pilihan != 0);
    }
}