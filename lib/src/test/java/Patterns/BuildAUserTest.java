package Patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuildAUserTest {
    @Test
    public void buildAUserWithMinimumRequiredFields(){
        User user =  new UserBuilder("firstName", "lastName").build();

        assertEquals("firstName", user.getFirstName());
    }

    @Test
    public void buildAUserWithMissingRequiredFields(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new UserBuilder("firstName", null)
                .build();
        });
    }

    @Test
    public void buildAUserWithSomeOptionalFields(){
        User user = new UserBuilder("firstName", "lastName")
                .age(30)
                .address("123 Any Street, Anytown, PA 12345")
                .build();

        assertEquals(30, user.getAge());
        assertEquals("123 Any Street, Anytown, PA 12345", user.getAddress());
    }

    @Test
    public void BuildAUserWithAllOptionalFields(){
        User user = new UserBuilder("firstName", "lastName")
                .age(30)
                .address("123 Any Street, Anytown, PA 12345")
                .phone("123.456.7890")
                .build();

        assertEquals("firstName", user.getFirstName());
        assertEquals("lastName", user.getLastName());
        assertEquals(30, user.getAge());
        assertEquals("123 Any Street, Anytown, PA 12345", user.getAddress());
        assertEquals("123.456.7890", user.getPhone());
    }
}
