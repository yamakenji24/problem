package library;

import java.util.*;

public class Borrower extends User {
    private List<Book> borrowCart;

    public Borrower(String id, String name) {
        super(id, name);
        this.borrowCart = new ArrayList<Book>();
    }

    public void removeFromCart(Book book) {
        this.borrowCart.remove(book);
    }

    @Override
    public void addToCart(Book book) {
        System.out.println("borrower book");
        this.borrowCart.add(book);
    }

    @Override
    public List<Book> getCarts() {
        return this.borrowCart;
    }
}