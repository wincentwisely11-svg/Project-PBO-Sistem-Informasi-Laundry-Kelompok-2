public class Transaksi{
    private String idTransaksi;
    private String tanggal;
    private String idPelanggan;
    private String idAdmin;
    private double totalBayar;
    private String statusBayar;
    
    public Transaksi(String idTransaksi, String tanggal, String idPelanggan, String idAdmin, double totalBayar, String statusBayar) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.idPelanggan = idPelanggan;
        this.idAdmin = idAdmin;
        this.totalBayar = totalBayar;
        this.statusBayar = statusBayar;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }
}