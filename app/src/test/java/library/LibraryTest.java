package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.*;
import org.junit.Test;

public class LibraryTest {
    @Test public void shouldCreateBook()
            throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        Book book = lib.createBook("1", "本のタイトル", "著者の名前", "出典元", 1997);

        Field field = book.getClass().getDeclaredField("title");
        field.setAccessible(true);

        String title = (String)field.get(book);
        assertThat(title, is("本のタイトル"));
    }

    @Test public void shouldAddBooks()
            throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        lib.addBooks("1", "本のタイトル1", "著者の名前", "出典元", 1997);

        Field field = lib.getClass().getDeclaredField("shelf");
        field.setAccessible(true);

        List<Book> actual = (List<Book>)field.get(lib);
        assertThat(actual.size(), is(1));
    }

    @Test public void shouldCreateBorrower()
            throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        User user = lib.createBorrower("1", "Yamada");

        assertThat(user.getName(), is("Yamada"));
    }

    @Test public void shouldAddUsers()
        throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        lib.addUsers("1", "Yamada");

        Field field = lib.getClass().getDeclaredField("users");
        field.setAccessible(true);

        List<User> actual = (List<User>)field.get(lib);
        assertThat(actual.size(), is(1));
    }

    @Test public void shouldFindUser()
            throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        lib.addUsers("1", "Yamada");
        Field field = lib.getClass().getDeclaredField("users");
        field.setAccessible(true);
        List<User> users = (List<User>)field.get(lib);

        User found = lib.findUser("1");
        assertThat(users, hasItems(found));
    }

    @Test public void userCouldNotBeFound()
            throws NoSuchFieldException, IllegalAccessException {
        Library lib = new Library();
        lib.addUsers("1", "Yamada");

        User notfound = lib.findUser("2");
        assertThat(notfound, nullValue());
    }

    @Test public void shouldBorrowBook() throws Exception {
        Library lib = new Library();
        lib.addUsers("1", "Yamada");
        lib.addBooks("1", "本のタイトル1", "著者の名前", "出典元", 1997);

        Boolean success = lib.borrowBook("1", "1");
        assertThat(success, is(true));
    }

    // private fieldに設定されているか、確認
    @Test public void fieldShelfshouldBePrivate()
            throws NoSuchFieldException, IllegalAccessException {
        try {
            Library lib = new Library();
            Field field = lib.getClass().getDeclaredField("shelf");

            List<Book> shelf = (List<Book>)field.get(lib);
            fail("shelf field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }

    @Test public void fieldUsersshouldBePrivate()
            throws NoSuchFieldException, IllegalAccessException {
        try {
            Library lib = new Library();
            Field field = lib.getClass().getDeclaredField("users");

            List<User> users = (List<User>)field.get(lib);
            fail("shelf field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }
}