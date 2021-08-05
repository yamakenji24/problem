package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class BorrowCartTest {

    @Test
    public void shouldGetUser() {
        BorrowCart cart = new BorrowCart();
        User user = new User("1", "Yamada");
        cart.setUser(user);
        assertThat(user, is(cart.getUser()));
    }
}