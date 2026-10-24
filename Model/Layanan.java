public class Layanan {
    private String kodeLayanan;
    private String namaLayanan;
    private double tarif;
    private String satuan;
    private int EstimasiPengerjaan;
    
    public Layanan(String kodeLayanan, String namaLayanan, double tarif, String satuan, int estimasiPengerjaan) {
        this.kodeLayanan = kodeLayanan;
        this.namaLayanan = namaLayanan;
        this.tarif = tarif;
        this.satuan = satuan;
        EstimasiPengerjaan = estimasiPengerjaan;
    }
    public String getKodeLayanan() {
        return kodeLayanan;
    }
    public void setKodeLayanan(String kodeLayanan) {
        this.kodeLayanan = kodeLayanan;
    }
    public String getNamaLayanan() {
        return namaLayanan;
    }
    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }
    public double getTarif() {
        return tarif;
    }
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }
    public String getSatuan() {
        return satuan;
    }
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    public int getEstimasiPengerjaan() {
        return EstimasiPengerjaan;
    }
    public void setEstimasiPengerjaan(int estimasiPengerjaan) {
        EstimasiPengerjaan = estimasiPengerjaan;
    }
}

