package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.lang.reflect.Field;

public class UserTest {
    private String name = "Yamada";
    private String userID = "1";
    Book book = new Book("1", "本のタイトル", "著者の名前", "出典元", 1997);
    Book book1 = new Book("1", "本のタイトル", "著者の名前", "出典元", 1997);

    @Test public void shouldGetName() {
        User user = new User(userID, name);
        assertThat(user.getName(), is(name));
    }

    @Test public void shoudGetID() {
        User user = new User(userID, name);
        assertThat(user.getID(), is(userID));
    }

    @Test public void bookShouldBeAddedToCart() throws NoSuchFieldException, IllegalAccessException {
        User user = new User(userID, name);
        user.addToCart(book);

        Field field = user.getClass().getDeclaredField("borrowCart");
        field.setAccessible(true);

        List<Book> actual = (List<Book>)field.get(user);
        assertThat(actual, hasItems(book));
        assertThat(actual.size(), is(1));
    }

    @Test public void removedFromCart() throws NoSuchFieldException, IllegalAccessException {
        User user = new User(userID, name);
        Field field = user.getClass().getDeclaredField("borrowCart");
        field.setAccessible(true);
        List<Book> actual = (List<Book>)field.get(user);

        user.addToCart(book);
        user.addToCart(book1);
        user.removeFromCart(book1);

        assertThat(actual, hasItems(book));
        assertThat(actual.size(), is(1));
    }

    @Test public void shouldGetCarts() throws Exception {
        User user = new User(userID, name);
        user.addToCart(book);

        assertThat(user.getCarts(), hasItems(book));
        assertThat(user.getCarts().size(), is(1));
    }

    // private fieldに設定されているか、確認
    @Test public void fieldIDshouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            User user = new User(userID, name);
            Field field = user.getClass().getDeclaredField("id");

            String id = (String)field.get(user);
            fail("id field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }

    @Test public void fieldNameShouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            User user = new User(userID, name);
            Field field = user.getClass().getDeclaredField("name");

            String name = (String)field.get(user);
            fail("name field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }

    @Test public void fieldCartShouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            User user = new User(userID, name);
            Field field = user.getClass().getDeclaredField("borrowCart");

            List<Book> borrowCart = (List<Book>)field.get(user);
            fail("borrowCart field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }
}