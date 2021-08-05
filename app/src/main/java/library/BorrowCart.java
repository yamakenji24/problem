package library;

import java.util.*;

public class BorrowCart {
    private User user;
    private List<Book> borrowedBooks = new ArrayList<Book>();

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return this.user;
    }

    public void borrow(Book book) {
        this.borrowedBooks.add(book);
    }
}