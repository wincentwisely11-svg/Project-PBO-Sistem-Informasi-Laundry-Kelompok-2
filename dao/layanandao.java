package dao;
import java.sql.*;
import java.util.Scanner;

// Letakkan file ini di folder src, sejajar dengan App.java, util.java, dan UserDAO.java.
// Koneksi memakai util.url, sama seperti di UserDAO.
public class layanandao {

    // ===== Menampilkan semua layanan =====
    public static void tampilDataLayanan(){
        System.out.println("| kode_layanan | nama_layanan | tarif | satuan | estimasi_pengerjaan |");
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sistemlaundrydb.layanan ORDER BY kode_layanan");
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("| " + rs.getString("kode_layanan") + " | " + rs.getString("nama_layanan") + " | "
                        + rs.getDouble("tarif") + " | " + rs.getString("satuan") + " | "
                        + rs.getInt("estimasi_pengerjaan") + " hari |");
            }
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mencari satu layanan berdasarkan kode =====
    public static void cariLayananByKode(String kode_layanan){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM sistemlaundrydb.layanan WHERE kode_layanan = ?")) {
            ps.setString(1, kode_layanan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Kode      : " + rs.getString("kode_layanan"));
                System.out.println("Nama      : " + rs.getString("nama_layanan"));
                System.out.println("Tarif     : " + rs.getDouble("tarif"));
                System.out.println("Satuan    : " + rs.getString("satuan"));
                System.out.println("Estimasi  : " + rs.getInt("estimasi_pengerjaan") + " hari");
            } else {
                System.out.println("Layanan dengan kode " + kode_layanan + " tidak ditemukan.");
            }
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Mencari layanan berdasarkan sebagian nama (huruf besar/kecil tidak dibedakan) =====
    public static void cariLayananByNama(String kata){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM sistemlaundrydb.layanan WHERE nama_layanan ILIKE ? ORDER BY kode_layanan")) {
            ps.setString(1, "%" + kata + "%");
            ResultSet rs = ps.executeQuery();
            boolean ada = false;
            System.out.println("| kode_layanan | nama_layanan | tarif | satuan | estimasi_pengerjaan |");
            while (rs.next()) {
                ada = true;
                System.out.println("| " + rs.getString("kode_layanan") + " | " + rs.getString("nama_layanan") + " | "
                        + rs.getDouble("tarif") + " | " + rs.getString("satuan") + " | "
                        + rs.getInt("estimasi_pengerjaan") + " hari |");
            }
            if (!ada) System.out.println("Tidak ada layanan yang namanya mengandung '" + kata + "'.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menambah layanan =====
    public static void tambahLayanan(String kode_layanan, String nama_layanan, double tarif, String satuan, int estimasi_pengerjaan){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "INSERT INTO sistemlaundrydb.layanan(kode_layanan, nama_layanan, tarif, satuan, estimasi_pengerjaan) values(?,?,?,?,?)")) {
            ps.setString(1, kode_layanan);
            ps.setString(2, nama_layanan);
            ps.setDouble(3, tarif);
            ps.setString(4, satuan);
            ps.setInt(5, estimasi_pengerjaan);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("Layanan berhasil ditambahkan.");
        } catch (SQLException ex) {
            if ("23505".equals(ex.getSQLState())) {
                System.err.println("Kode layanan " + kode_layanan + " sudah dipakai.");
            } else {
                System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
            }
        }
    }

    // ===== Mengubah data layanan =====
    public static void updateLayanan(String kode_layanan, String nama_layanan, double tarif, String satuan, int estimasi_pengerjaan){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "UPDATE sistemlaundrydb.layanan SET nama_layanan = ?, tarif = ?, satuan = ?, estimasi_pengerjaan = ? WHERE kode_layanan = ?")) {
            ps.setString(1, nama_layanan);
            ps.setDouble(2, tarif);
            ps.setString(3, satuan);
            ps.setInt(4, estimasi_pengerjaan);
            ps.setString(5, kode_layanan);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("Data layanan berhasil diubah.");
            else System.out.println("Layanan dengan kode " + kode_layanan + " tidak ditemukan.");
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    // ===== Menghapus layanan =====
    public static void hapusLayanan(String kode_layanan){
        try (
            Connection con = DriverManager.getConnection(util.url);
            PreparedStatement ps = con.prepareStatement(
        "DELETE FROM sistemlaundrydb.layanan WHERE kode_layanan = ?")) {
            ps.setString(1, kode_layanan);
            int affected = ps.executeUpdate();
            if (affected > 0) System.out.println("Layanan berhasil dihapus.");
            else System.out.println("Layanan dengan kode " + kode_layanan + " tidak ditemukan.");
        } catch (SQLException ex) {
            if ("23503".equals(ex.getSQLState())) {
                System.err.println("Layanan tidak bisa dihapus karena sudah dipakai di transaksi.");
            } else {
                System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
            }
        }
    }

    // ===== SUBMENU DATA LAYANAN (dipanggil dari Main) =====
    public static void menuLayanan(Scanner input){
        int pilihan;
        do {
            System.out.println("--------- DATA LAYANAN ---------");
            System.out.println("1. Tampilkan semua layanan");
            System.out.println("2. Cari layanan berdasarkan kode");
            System.out.println("3. Cari layanan berdasarkan nama");
            System.out.println("4. Tambah layanan");
            System.out.println("5. Ubah data layanan");
            System.out.println("6. Hapus layanan");
            System.out.println("0. Kembali ke menu utama");
            System.out.println("--------------------------------");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();
            input.nextLine();   // membuang sisa enter setelah angka
            System.out.println();

            switch (pilihan) {
                case 1:
                    tampilDataLayanan();
                    break;
                case 2:
                    System.out.print("Kode layanan : ");
                    String kodeCari = input.nextLine();
                    cariLayananByKode(kodeCari);
                    break;
                case 3:
                    System.out.print("Kata kunci nama : ");
                    String kataCari = input.nextLine();
                    cariLayananByNama(kataCari);
                    break;
                case 4:
                    System.out.print("Kode layanan        : ");
                    String kodeBaru = input.nextLine();
                    System.out.print("Nama layanan        : ");
                    String namaBaru = input.nextLine();
                    System.out.print("Tarif               : ");
                    double tarifBaru = input.nextDouble();
                    input.nextLine();
                    System.out.print("Satuan (kg / pcs)   : ");
                    String satuanBaru = input.nextLine();
                    System.out.print("Estimasi (hari)     : ");
                    int estimasiBaru = input.nextInt();
                    input.nextLine();
                    if (satuanBaru.equals("kg") || satuanBaru.equals("pcs")) {
                        tambahLayanan(kodeBaru, namaBaru, tarifBaru, satuanBaru, estimasiBaru);
                    } else {
                        System.out.println("Satuan harus 'kg' atau 'pcs'.");
                    }
                    break;
                case 5:
                    System.out.print("Kode layanan yang diubah : ");
                    String kodeUbah = input.nextLine();
                    System.out.print("Nama baru                : ");
                    String namaUbah = input.nextLine();
                    System.out.print("Tarif baru               : ");
                    double tarifUbah = input.nextDouble();
                    input.nextLine();
                    System.out.print("Satuan baru (kg / pcs)   : ");
                    String satuanUbah = input.nextLine();
                    System.out.print("Estimasi baru (hari)     : ");
                    int estimasiUbah = input.nextInt();
                    input.nextLine();
                    if (satuanUbah.equals("kg") || satuanUbah.equals("pcs")) {
                        updateLayanan(kodeUbah, namaUbah, tarifUbah, satuanUbah, estimasiUbah);
                    } else {
                        System.out.println("Satuan harus 'kg' atau 'pcs'.");
                    }
                    break;
                case 6:
                    System.out.print("Kode layanan yang dihapus : ");
                    String kodeHapus = input.nextLine();
                    hapusLayanan(kodeHapus);
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