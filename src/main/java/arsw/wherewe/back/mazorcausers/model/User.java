package arsw.wherewe.back.mazorcausers.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userFirstName;
    private String userFullName;
    private String userEmail;
    private String userTimeZone;

    public User(String id, String firstName, String fullName, String email, String timeZone) {
        this.id = id;
        this.userFirstName = firstName;
        this.userFullName = fullName;
        this.userEmail = email;
        this.userTimeZone = timeZone;
    }

    public User(){

    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserTimeZone() {
        return userTimeZone;
    }

    public void setUserTimeZone(String userTimeZone) {
        this.userTimeZone = userTimeZone;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userFullName='" + userFullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTimeZone='" + userTimeZone + '\'' +
                '}';
    }

}
