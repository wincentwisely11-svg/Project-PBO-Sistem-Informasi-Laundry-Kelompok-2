package dao;
import java.sql.*;
import java.util.Scanner;

// Letakkan file ini di folder src, sejajar dengan App.java dan util.java.
// Koneksi memakai util.url, sama seperti di App.java.
public class userdao {

    // ===== Menampilkan semua user =====
    public static void tampilDataUser(){
        System.out.println("| id_user | nama | username | password |");
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sistemlaundrydb.user ORDER BY id_user");
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("| " + rs.getString("id_user") + " | " + rs.getString("nama") + " | "
                        + rs.getString("username") + " | " + rs.getString("password") + " |");
            }
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mencari satu user berdasarkan ID =====
    public static void cariUserById(String id_user){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM sistemlaundrydb.user WHERE id_user = ?")) {
            ps.setString(1, id_user);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID       : " + rs.getString("id_user"));
                System.out.println("Nama     : " + rs.getString("nama"));
                System.out.println("Username : " + rs.getString("username"));
                System.out.println("Password : " + rs.getString("password"));
            } else {
                System.out.println("User dengan ID " + id_user + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menambah user =====
    public static void tambahUser(String id_user, String nama, String username, String password){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "INSERT INTO sistemlaundrydb.user(id_user, nama, username, password) values(?,?,?,?)")) {
            ps.setString(1, id_user);
            ps.setString(2, nama);
            ps.setString(3, username);
            ps.setString(4, password);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("User berhasil ditambahkan.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mengubah nama saja =====
    public static void updateNamaUser(String id_user, String nama){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "UPDATE sistemlaundrydb.user SET nama = ? WHERE id_user = ?")) {
            ps.setString(1, nama);
            ps.setString(2, id_user);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("Nama user berhasil diubah.");
            else System.out.println("User dengan ID " + id_user + " tidak ditemukan.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mengubah semua data user =====
    public static void updateUser(String id_user, String nama, String username, String password){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "UPDATE sistemlaundrydb.user SET nama = ?, username = ?, password = ? WHERE id_user = ?")) {
            ps.setString(1, nama);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, id_user);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("Data user berhasil diubah.");
            else System.out.println("User dengan ID " + id_user + " tidak ditemukan.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menghapus user =====
    public static void hapusUser(String id_user){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "DELETE FROM sistemlaundrydb.user WHERE id_user=?")) {
            ps.setString(1, id_user);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("User berhasil dihapus.");
            else System.out.println("User dengan ID " + id_user + " tidak ditemukan.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Login: true kalau username dan password cocok =====
    public static boolean login(String username, String password){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM sistemlaundrydb.user WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
            return false;
        }
    }

    // ===== SUBMENU DATA USER (dipanggil dari Main) =====
    public static void menuUser(Scanner input){
        int pilihan;
        do {
            System.out.println("---------- DATA USER ----------");
            System.out.println("1. Tampilkan semua user");
            System.out.println("2. Cari user berdasarkan ID");
            System.out.println("3. Tambah user");
            System.out.println("4. Ubah data user");
            System.out.println("5. Hapus user");
            System.out.println("0. Kembali ke menu utama");
            System.out.println("-------------------------------");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();
            input.nextLine();   // membuang sisa enter setelah angka
            System.out.println();

            switch (pilihan) {
                case 1:
                    tampilDataUser();
                    break;
                case 2:
                    System.out.print("ID user : ");
                    String idCari = input.nextLine();
                    cariUserById(idCari);
                    break;
                case 3:
                    System.out.print("ID user  : ");
                    String idBaru = input.nextLine();
                    System.out.print("Nama     : ");
                    String namaBaru = input.nextLine();
                    System.out.print("Username : ");
                    String usernameBaru = input.nextLine();
                    System.out.print("Password : ");
                    String passwordBaru = input.nextLine();
                    tambahUser(idBaru, namaBaru, usernameBaru, passwordBaru);
                    break;
                case 4:
                    System.out.print("ID user yang diubah : ");
                    String idUbah = input.nextLine();
                    System.out.print("Nama baru           : ");
                    String namaUbah = input.nextLine();
                    System.out.print("Username baru       : ");
                    String usernameUbah = input.nextLine();
                    System.out.print("Password baru       : ");
                    String passwordUbah = input.nextLine();
                    updateUser(idUbah, namaUbah, usernameUbah, passwordUbah);
                    break;
                case 5:
                    System.out.print("ID user yang dihapus : ");
                    String idHapus = input.nextLine();
                    hapusUser(idHapus);
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
