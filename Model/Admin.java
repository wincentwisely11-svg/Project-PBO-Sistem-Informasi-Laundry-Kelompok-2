public class Admin {

    private String idAdmin;
    private String nama;
    private String username;
    private String password;

    public Admin(String idAdmin, String nama, String username, String password) {
        this.idAdmin = idAdmin;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }
    
    public String getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
