package arsw.wherewe.back.mazorcausers.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void userDTOInitializationWithAllFields() {
        UserDTO userDTO = new UserDTO("507f1f77bcf86cd799439011", "John", "John Doe", "john.doe@example.com", "America/New_York", "https://example.com/profile1.jpg");

        assertEquals("507f1f77bcf86cd799439011", userDTO.getId());
        assertEquals("John", userDTO.getUserFirstName());
        assertEquals("John Doe", userDTO.getUserFullName());
        assertEquals("john.doe@example.com", userDTO.getUserEmail());
        assertEquals("America/New_York", userDTO.getUserTimeZone());
        assertEquals("https://example.com/profile1.jpg", userDTO.getProfilePicture());
    }

    @Test
    void userDTOInitializationWithNoFields() {
        UserDTO userDTO = new UserDTO();

        assertNull(userDTO.getId());
        assertNull(userDTO.getUserFirstName());
        assertNull(userDTO.getUserFullName());
        assertNull(userDTO.getUserEmail());
        assertNull(userDTO.getUserTimeZone());
        assertNull(userDTO.getProfilePicture());
    }

    @Test
    void userDTOSettersAndGetters() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("507f1f77bcf86cd799439011");
        userDTO.setUserFirstName("John");
        userDTO.setUserFullName("John Doe");
        userDTO.setUserEmail("john.doe@example.com");
        userDTO.setUserTimeZone("America/New_York");
        userDTO.setProfilePicture("https://example.com/profile1.jpg");

        assertEquals("507f1f77bcf86cd799439011", userDTO.getId());
        assertEquals("John", userDTO.getUserFirstName());
        assertEquals("John Doe", userDTO.getUserFullName());
        assertEquals("john.doe@example.com", userDTO.getUserEmail());
        assertEquals("America/New_York", userDTO.getUserTimeZone());
        assertEquals("https://example.com/profile1.jpg", userDTO.getProfilePicture());
    }

    @Test
    void userDTOToString() {
        UserDTO userDTO = new UserDTO("507f1f77bcf86cd799439011", "John", "John Doe", "john.doe@example.com", "America/New_York", "https://example.com/profile1.jpg");
        String expectedString = "UserDTO{id='507f1f77bcf86cd799439011', userFirstName='John', userFullName='John Doe', userEmail='john.doe@example.com', userTimeZone='America/New_York', profilePicture='https://example.com/profile1.jpg'}";

        assertEquals(expectedString, userDTO.toString());
    }
}