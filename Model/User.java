public class User {

    private String idUser;
    private String nama;
    private String username;
    private String password;

    public User(String idUser, String nama, String username, String password) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }
    
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
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
