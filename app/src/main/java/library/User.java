package library;

import java.util.*;

public class User {
    private String id;
    private String name;
    private List<Book> borrowCart;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowCart = new ArrayList<Book>();
    }
    public String getID() { return this.id; }
    public String getName() {
        return this.name;
    }

    public void removeFromCart(Book book) {
        this.borrowCart.remove(book);
    }
    public void addToCart(Book book) {
        this.borrowCart.add(book);
    }
}