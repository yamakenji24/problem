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

    public User createUser(String id, String name) {
        User user = new User(id, name);
        return user;
    }

    public void addBooks() {
        this.shelf.add(this.createBook("1", "本のタイトル1", "著者の名前", "出典元", 1997));
        this.shelf.add(this.createBook("2", "本のタイトル2", "著者の名前", "出典元", 1998));
        this.shelf.add(this.createBook("3", "本のタイトル3", "著者の名前", "出典元", 1999));
    }
    public void addUsers() {
        this.users.add(this.createUser("1", "Yamada"));
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