package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
    private String name = "Yamada";
    private String userID = "1";
    User user = new User(userID, name);

    @Test
    public void shouldGetName() {
        assertThat(user.getName(), is(name));
    }

    @Test
    public void shoudGetID() {
        assertThat(user.getID(), is(userID));
    }

    @Test
    public void bookShouldBeAdded() {
        
    }

    /*@Test
    public void shouldFail() {
        assertThat(user.id, is("1"));
    }*/

}