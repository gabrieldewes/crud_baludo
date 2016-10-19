package br.ulbra.Domain;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class User {
    private int id;
    private String fullname;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String fullname, String useraname, String password) {
        this.id = id;
        this.fullname = fullname;
        this.username = useraname;
        this.password = password;
    }

    public User(String fullname, String useraname, String password) {
        this.fullname = fullname;
        this.username = useraname;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
