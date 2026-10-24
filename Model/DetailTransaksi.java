public class DetailTransaksi {
    private String idDetail;
    private String idTransaksi;
    private String kodeLayanan;
    private double jumlah;
    private double hargaSatuan;
    private double subtotal;

    public DetailTransaksi(String idDetail, String idTransaksi, String kodeLayanan, double jumlah, double hargaSatuan, double subtotal) {
        this.idDetail = idDetail;
        this.idTransaksi = idTransaksi;
        this.kodeLayanan = kodeLayanan;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.subtotal = subtotal;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getKodeLayanan() {
        return kodeLayanan;
    }

    public void setKodeLayanan(String kodeLayanan) {
        this.kodeLayanan = kodeLayanan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
