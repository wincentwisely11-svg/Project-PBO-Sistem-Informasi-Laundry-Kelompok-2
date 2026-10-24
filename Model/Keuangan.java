public class Keuangan {
    private String idTransaksi;
    private String tanggal;
    private String idPelanggan;
    private String kodeLayanan;
    private Double jumlah;
    private Double totalBayar;
    private String statusBayar;

    public Keuangan(String idTransaksi, String tanggal, String idPelanggan, String kodeLayanan, Double jumlah, Double totalBayar, String statusBayar) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.idPelanggan = idPelanggan;
        this.kodeLayanan = kodeLayanan;
        this.jumlah = jumlah;
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

    public String getKodeLayanan() {
        return kodeLayanan;
    }

    public void setKodeLayanan(String kodeLayanan) {
        this.kodeLayanan = kodeLayanan;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public Double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }
}
