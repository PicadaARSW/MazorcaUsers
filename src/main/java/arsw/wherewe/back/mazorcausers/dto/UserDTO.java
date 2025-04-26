package arsw.wherewe.back.mazorcausers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserDTO", description = "DTO representing a user in the system")
public class UserDTO {

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

    @Schema(description = "URL of user's profile picture", example = "https://example.com/profile1.jpg")
    private String profilePicture;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String id, String userFirstName, String userFullName, String userEmail, String userTimeZone, String profilePicture) {
        this.id = id;
        this.userFirstName = userFirstName;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userTimeZone = userTimeZone;
        this.profilePicture = profilePicture;
    }

    // Getters and Setters
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTimeZone() {
        return userTimeZone;
    }

    public void setUserTimeZone(String userTimeZone) {
        this.userTimeZone = userTimeZone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userFullName='" + userFullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTimeZone='" + userTimeZone + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}