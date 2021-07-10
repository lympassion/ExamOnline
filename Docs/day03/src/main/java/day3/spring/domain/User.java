package day3.spring.domain;



public class User{

    private String  id;
    private String type;
    private String password;

    public User() {
    }

    public User(String id, String type, String password) {
        this.id = id;
        this.type = type;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

