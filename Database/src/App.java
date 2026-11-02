import java.sql.*;
public class App {
    static String url = "jdbc:postgresql://pgsql-dbas-jkt1-006.sumobase.my.id:6432/db6c78b45dc098e018?user=uIc5dgICS2yNG52Og.jkt1_006&password=d6f48a618753914c03af736a";
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(url)) {
            tampilkanUser(con);
            tampilkanPelanggan(con);
            tampilkanLayanan(con);
            tampilkanTransaksi(con);
            tampilkanDetailTransaksi(con);
        } catch (SQLException ex) {
            System.err.println("Akses database gagal: " + ex.getSQLState() + " - " + ex.getMessage());
        }
    }
    // =======================[ Tabel User ]=======================
    public static void tampilkanUser(Connection con) throws SQLException {
        System.out.println("=============== TABEL USER ===============");
        System.out.println("| id_user | nama | username | password |");
        try (
            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM sistemlaundrydb.user;")) {
            // ps.setInt(1, 101);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User u = new User(
                        rs.getString("id_user"),
                        rs.getString("nama"),
                        rs.getString("username"),
                        rs.getString("password"));
                System.out.println(u);
            }
            System.out.println("");
        }
        } catch (SQLException ex) {
        System.err.println("Akses database gagal: " + ex.getSQLState());
        }
    }

    // =======================[ Tabel Pelanggan ]=======================
    public static void tampilkanPelanggan(Connection con) throws SQLException {
        System.out.println("=============== TABEL PELANGGAN ===============");
        System.out.println("| id_pelanggan | nama | no_telepon | alamat |");
        try (
            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM sistemlaundrydb.pelanggan;")) {
            // ps.setInt(1, 101);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pelanggan p = new Pelanggan(
                        rs.getString("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("no_telepon"),
                        rs.getString("alamat"));
                System.out.println(p);
            }
            System.out.println("");
        }
        } catch (SQLException ex) {
        System.err.println("Akses database gagal: " + ex.getSQLState());
        }
    }

    // =======================[ Tabel Layanan ]=======================
    public static void tampilkanLayanan(Connection con) throws SQLException {
        System.out.println("=============== TABEL LAYANAN ===============");
        System.out.println("| kode_layanan | nama_layanan | tarif | satuan | estimasi_pengerjaan |");
        try (
            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM sistemlaundrydb.layanan;")) {
            // ps.setInt(1, 101);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Layanan l = new Layanan(
                        rs.getString("kode_layanan"),
                        rs.getString("nama_layanan"),
                        rs.getDouble("tarif"),
                        rs.getString("satuan"),
                        rs.getInt("estimasi_pengerjaan"));
                System.out.println(l);
            }
            System.out.println("");
        }
        } catch (SQLException ex) {
        System.err.println("Akses database gagal: " + ex.getSQLState());
        }
    }

    // =======================[ Tabel Transaksi ]=======================
    public static void tampilkanTransaksi(Connection con) throws SQLException {
        System.out.println("=============== TABEL TRANSAKSI ===============");
        System.out.println("| id_transaksi | tanggal | id_pelanggan | id_user | total_bayar | status_bayar |");
        try (
            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM sistemlaundrydb.transaksi;")) {
            // ps.setInt(1, 101);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transaksi t = new Transaksi(
                        rs.getString("id_transaksi"),
                        rs.getString("tanggal"),
                        rs.getString("id_pelanggan"),
                        rs.getString("id_user"),
                        rs.getDouble("total_bayar"),
                        rs.getString("status_bayar"));
                System.out.println(t);
            }
            System.out.println("");
        }
        } catch (SQLException ex) {
        System.err.println("Akses database gagal: " + ex.getSQLState());
        }
    }

    // =======================[ Tabel Detail Transaksi ]=======================
    public static void tampilkanDetailTransaksi(Connection con) throws SQLException {
        System.out.println("=============== TABEL DETAIL TRANSAKSI ===============");
        System.out.println("| id_detail | id_transaksi | kode_layanan | jumlah | harga_satuan | subtotal |");
        try (
            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM sistemlaundrydb.detail_transaksi;")) {
            // ps.setInt(1, 101);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetailTransaksi d = new DetailTransaksi(
                        rs.getString("id_detail"),
                        rs.getString("id_transaksi"),
                        rs.getString("kode_layanan"),
                        rs.getDouble("jumlah"),
                        rs.getDouble("harga_satuan"),
                        rs.getDouble("subtotal"));
                System.out.println(d);
            }
            System.out.println("");
        }
        } catch (SQLException ex) {
        System.err.println("Akses database gagal: " + ex.getSQLState());
        }
    }
}