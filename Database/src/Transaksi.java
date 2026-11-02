public class Transaksi {
    private String idTransaksi;
    private String tanggal;
    private String idPelanggan;
    private String idUser;
    private double totalBayar;
    private String statusBayar;

    public Transaksi(String idTransaksi, String tanggal, String idPelanggan, String idUser, double totalBayar, String statusBayar) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.idPelanggan = idPelanggan;
        this.idUser = idUser;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "| " + idTransaksi + " | " + tanggal + " | " + idPelanggan + " | " + idUser + " | " + totalBayar + " | " + statusBayar + " |";
    }
}