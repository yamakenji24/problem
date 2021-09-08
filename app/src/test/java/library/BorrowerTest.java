package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.lang.reflect.Field;

public class BorrowerTest {
    private String name = "Yamada";
    private String userID = "1";
    Book book = new Book("1", "本のタイトル", "著者の名前", "出典元", 1997);
    Book book1 = new Book("1", "本のタイトル", "著者の名前", "出典元", 1997);

    @Test public void bookShouldBeAddedToCart() throws NoSuchFieldException, IllegalAccessException {
        Borrower borrower = new Borrower(userID, name);
        borrower.addToCart(book);

        Field field = borrower.getClass().getDeclaredField("borrowCart");
        field.setAccessible(true);

        List<Book> actual = (List<Book>)field.get(borrower);
        assertThat(actual, hasItems(book));
        assertThat(actual.size(), is(1));
    }

    @Test public void removedFromCart() throws NoSuchFieldException, IllegalAccessException {
        Borrower borrower = new Borrower(userID, name);
        Field field = borrower.getClass().getDeclaredField("borrowCart");
        field.setAccessible(true);
        List<Book> actual = (List<Book>)field.get(borrower);

        borrower.addToCart(book);
        borrower.addToCart(book1);
        borrower.removeFromCart(book1);

        assertThat(actual, hasItems(book));
        assertThat(actual.size(), is(1));
    }

    @Test public void shouldGetCarts() throws Exception {
        Borrower borrower = new Borrower(userID, name);
        borrower.addToCart(book);

        assertThat(borrower.getCarts(), hasItems(book));
        assertThat(borrower.getCarts().size(), is(1));
    }

    // private fieldに設定されているか、確認
    @Test public void fieldCartShouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            Borrower borrower = new Borrower(userID, name);
            Field field = borrower.getClass().getDeclaredField("borrowCart");

            List<Book> borrowCart = (List<Book>)field.get(borrower);
            fail("borrowCart field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }
}