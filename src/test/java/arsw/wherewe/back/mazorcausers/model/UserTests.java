package arsw.wherewe.back.mazorcausers.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    @Test
    void userConstructorAndGetters() {
        User user = new User("1", "John", "John Doe", "john.doe@example.com", "UTC", "https://example.com/profile1.jpg");
        assertEquals("1", user.getId());
        assertEquals("John", user.getUserFirstName());
        assertEquals("John Doe", user.getUserFullName());
        assertEquals("john.doe@example.com", user.getUserEmail());
        assertEquals("UTC", user.getUserTimeZone());
        assertEquals("https://example.com/profile1.jpg", user.getProfilePicture());
    }

    @Test
    void userSetters() {
        User user = new User();
        user.setId("2");
        user.setUserFirstName("Jane");
        user.setUserFullName("Jane Doe");
        user.setUserEmail("jane.doe@example.com");
        user.setUserTimeZone("PST");
        user.setProfilePicture("https://example.com/profile2.jpg");
        assertEquals("2", user.getId());
        assertEquals("Jane", user.getUserFirstName());
        assertEquals("Jane Doe", user.getUserFullName());
        assertEquals("jane.doe@example.com", user.getUserEmail());
        assertEquals("PST", user.getUserTimeZone());
        assertEquals("https://example.com/profile2.jpg", user.getProfilePicture());
    }

    @Test
    void userToString() {
        User user = new User("3", "Alice", "Alice Wonderland", "alice@example.com", "EST", "https://example.com/profile2.jpg");
        String expected = "User{id='3', userFirstName='Alice', userFullName='Alice Wonderland', userEmail='alice@example.com', userTimeZone='EST', profilePicture='https://example.com/profile2.jpg'}";
        assertEquals(expected, user.toString());
    }

    @Test
    void userEmptyConstructor() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getUserFirstName());
        assertNull(user.getUserFullName());
        assertNull(user.getUserEmail());
        assertNull(user.getUserTimeZone());
        assertNull(user.getProfilePicture());
    }
}