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
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

<<<<<<< HEAD
    @Column(name = "email")
    private String email;
=======
    @Column(name = "user_email")
    private String userEmail;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba

    @Column(name = "user_type")
    private String user_type;

    public User(String userName, String userType, String email,String password) {
        this.user_type = userType;
        this.user_name = userName;
        this.password = password;
<<<<<<< HEAD
        this.email = email;
=======
        this.userEmail = email;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    }
    
    public User(int user_id, String userName, String userType, String email,String password) {
        this.user_type = userType;
        this.user_name = userName;
        this.password = password;
<<<<<<< HEAD
        this.email = email;
        this.user_id = user_id;
    }

=======
        this.userEmail = email;
        this.user_id = user_id;
    }

    public User() {
    }

>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
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
<<<<<<< HEAD
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
=======
        return userEmail;
    }
    public void setEmail(String email) {
        this.userEmail = email;
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    }

    @Override
    public String toString() {

        return "User [ id= "+user_id+" , user_name= "+user_name+" , "
<<<<<<< HEAD
                + " email= "+email+" , user_type = "+user_type+" ]";
=======
                + " email= "+userEmail+" , user_type = "+user_type+" ]";
>>>>>>> 7c2168bffa36cc7429aeb41fec7e2db08ba09eba
    }



}
