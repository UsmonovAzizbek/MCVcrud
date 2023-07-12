import java.util.StringTokenizer;

public class Users {
    private Integer id;
    private String username;
    private String password;
    private String address;
    private boolean admin;

    public Users(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;

    }

    public Users(int id, String username, String password, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;



    }

    public Users(Integer id, String username, String password, String address, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.admin = admin;

    }

    public Users() {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.admin = admin;
    }

    public Users(String username, String password, String address, boolean admin) {

    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
