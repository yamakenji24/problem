package library;

import java.util.*;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getID() { return this.id; }
    public String getName() {
        return this.name;
    }

    public void addToCart(Book book) {}
    public List<Book> getCarts() {
        return new ArrayList<Book>();
    }
}