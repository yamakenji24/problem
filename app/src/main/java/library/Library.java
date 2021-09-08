package library;

import java.util.*;

public class Library {
    private List<Book> shelf = new ArrayList<Book>();
    private List<User> users = new ArrayList<User>();

    public void printWelcomeMessage(){
        System.out.println("ようこそ図書館システムへ．");
    }

    public void printShelfInfo() {
        for (Book book: shelf) {
            book.printBookInfo();
        }
    }
    public Book createBook(String id, String title, String authors, String publisher, Integer publishYear) {
        Book book = new Book(id, title, authors, publisher, publishYear);
        return book;
    }

    public Borrower createBorrower(String id, String name) {
        Borrower borrower = new Borrower(id, name);
        return borrower;
    }

    public void addBooks(String id, String title, String authors, String publisher, Integer publishYear) {
        this.shelf.add(this.createBook(id, title, authors, publisher, publishYear));
    }

    public void addUsers(String id, String name) {
        this.users.add(this.createBorrower(id, name));
    }

    public User findUser(String userID) {
        for (User user: users) {
            if (Objects.equals(userID, user.getID())) {
                return user;
            }
        }
        return null;
    }

    public boolean borrowBook(String userID, String bookID) {
        User user = findUser(userID);
        if (user == null) { return false; }

        for (Book book: shelf) {
            if (Objects.equals(bookID, book.getID())) {
                user.addToCart(book);
                System.out.println("レンタルに成功しました");
                return true;
            }
        }
        System.out.println("本が見つからなかったみたいです");
        return false;
    }

}