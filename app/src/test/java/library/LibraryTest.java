package library;

import java.io.ByteArrayOutputStream;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldHaveWelcomeMessage() {
        Library lib = new Library();
        lib.printWelcomeMessage();
        assertNotNull("should have a welcome message", outContent.toString());
    }

    @Test
    public void shouldCreateBook() {
        Library lib = new Library();
        Book book = lib.createBook("1", "本のタイトル", "著者の名前", "出典元", 1997);
        assertThat(book.getTitle(), is("本のタイトル"));
    }

    @Test
    public void shouldCreateUser() {
        Library lib = new Library();
        User user = lib.createUser("1", "Yamada");
        assertThat(user.getName(), is("Yamada"));
    }
}