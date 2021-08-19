package library;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.reflect.Field;

public class BookTest {
    Book book = new Book("1", "本のタイトル", "著者の名前", "出典元", 1997);

    @Test public void shouldGetID() {
        String expectID = "1";
        assertThat(book.getID(), is(expectID));
    }

    @Test public void shouldGetTitle() {
        String expectTitle = "本のタイトル";
        assertThat(book.getTitle(), is(expectTitle));
    }

    // private fieldに設定されているか、確認
    @Test public void fieldIDshouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            Field field = book.getClass().getDeclaredField("id");

            String id = (String)field.get(book);
            fail("id field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }

    @Test public void fieldTitleshouldBePrivate() throws NoSuchFieldException, IllegalAccessException {
        try {
            Field field = book.getClass().getDeclaredField("title");

            String id = (String)field.get(book);
            fail("title field should be private");
        } catch(IllegalAccessException e) {
            // pass
        }
    }
}