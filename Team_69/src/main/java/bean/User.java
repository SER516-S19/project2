package bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_type")
    private String user_type;

    public User(String userName, String userType, String email,String password) {
        this.user_type = userType;
        this.user_name = userName;
        this.password = password;
        this.userEmail = email;
    }
    
    public User(int user_id, String userName, String userType, String email,String password) {
        this.user_type = userType;
        this.user_name = userName;
        this.password = password;
        this.userEmail = email;
        this.user_id = user_id;
    }

    public User() {}

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_type() {
        return user_type;
    }
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return userEmail;
    }
    public void setEmail(String email) {
        this.userEmail = email;
    }

    @Override
    public String toString() {

        return "User [ id= "+user_id+" , user_name= "+user_name+" , "
                + " email= "+userEmail+" , user_type = "+user_type+" ]";
    }



}
