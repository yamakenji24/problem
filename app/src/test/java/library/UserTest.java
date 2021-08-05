package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
    private String name = "Yamada";
    User user = new User("1", name);

    @Test
    public void shouldGetName() {
        assertThat(user.getName(), is(name));
    }

    /*@Test
    public void shouldFail() {
        assertThat(user.id, is("1"));
    }*/

}