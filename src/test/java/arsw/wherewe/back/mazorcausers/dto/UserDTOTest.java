package arsw.wherewe.back.mazorcausers.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void userDTOInitializationWithAllFields() {
        UserDTO userDTO = new UserDTO("507f1f77bcf86cd799439011", "John", "John Doe", "john.doe@example.com", "America/New_York");

        assertEquals("507f1f77bcf86cd799439011", userDTO.getId());
        assertEquals("John", userDTO.getUserFirstName());
        assertEquals("John Doe", userDTO.getUserFullName());
        assertEquals("john.doe@example.com", userDTO.getUserEmail());
        assertEquals("America/New_York", userDTO.getUserTimeZone());
    }

    @Test
    void userDTOInitializationWithNoFields() {
        UserDTO userDTO = new UserDTO();

        assertNull(userDTO.getId());
        assertNull(userDTO.getUserFirstName());
        assertNull(userDTO.getUserFullName());
        assertNull(userDTO.getUserEmail());
        assertNull(userDTO.getUserTimeZone());
    }

    @Test
    void userDTOSettersAndGetters() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("507f1f77bcf86cd799439011");
        userDTO.setUserFirstName("John");
        userDTO.setUserFullName("John Doe");
        userDTO.setUserEmail("john.doe@example.com");
        userDTO.setUserTimeZone("America/New_York");

        assertEquals("507f1f77bcf86cd799439011", userDTO.getId());
        assertEquals("John", userDTO.getUserFirstName());
        assertEquals("John Doe", userDTO.getUserFullName());
        assertEquals("john.doe@example.com", userDTO.getUserEmail());
        assertEquals("America/New_York", userDTO.getUserTimeZone());
    }

    @Test
    void userDTOToString() {
        UserDTO userDTO = new UserDTO("507f1f77bcf86cd799439011", "John", "John Doe", "john.doe@example.com", "America/New_York");
        String expectedString = "UserDTO{id='507f1f77bcf86cd799439011', userFirstName='John', userFullName='John Doe', userEmail='john.doe@example.com', userTimeZone='America/New_York'}";

        assertEquals(expectedString, userDTO.toString());
    }
}