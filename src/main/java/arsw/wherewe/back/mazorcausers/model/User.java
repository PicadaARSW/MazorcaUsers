package arsw.wherewe.back.mazorcausers.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User model class
 * @version 1.0
 */
@Document(collection = "users")
@Schema(name = "User", description = "User Entity Representing a System User")
public class User {
    @Id
    @Schema(description = "Unique identifier of the user", example = "507f1f77bcf86cd799439011")
    private String id;
    @Schema(description = "User's first name", example = "John")
    private String userFirstName;
    @Schema(description = "User's full name", example = "John Doe")
    private String userFullName;
    @Schema(description = "User's email address", example = "john.doe@example.com")
    private String userEmail;
    @Schema(description = "User's time zone", example = "America/New_York")
    private String userTimeZone;

    /**
     * Constructor for User
     * @param id
     * @param firstName
     * @param fullName
     * @param email
     * @param timeZone
     */
    public User(String id, String firstName, String fullName, String email, String timeZone) {
        this.id = id;
        this.userFirstName = firstName;
        this.userFullName = fullName;
        this.userEmail = email;
        this.userTimeZone = timeZone;
    }

    /**
     * Empty constructor for User
     */
    public User(){

    }

    /**
     * Get the user email
     * @return userEmail
     */
    public String getUserEmail(){
        return userEmail;
    }

    /**
     * Get the user id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the user id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the user first name
     * @return userFirstName
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Set the user first name
     * @param userFirstName
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * Get the user full name
     * @return userFullName
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     * Set the user full name
     * @param userFullName
     */
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    /**
     * Get the user time zone
     * @return userTimeZone
     */
    public String getUserTimeZone() {
        return userTimeZone;
    }

    /**
     * Set the user time zone
     * @param userTimeZone
     */
    public void setUserTimeZone(String userTimeZone) {
        this.userTimeZone = userTimeZone;
    }

    /**
     * Set the user email
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Override the toString method
     * @return String
     */
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
