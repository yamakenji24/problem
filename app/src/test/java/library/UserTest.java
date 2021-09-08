package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.lang.reflect.Field;

public class UserTest {
    class MockUser extends User {
        public MockUser(String id, String name) {
            super(id, name);
        }
    }
    private String name = "Yamada";
    private String userID = "1";

    @Test public void shouldGetName() {
        User user = new MockUser(userID, name);
        assertThat(user.getName(), is(name));
    }

    @Test public void shoudGetID() {
        User user = new MockUser(userID, name);
        assertThat(user.getID(), is(userID));
    }

}