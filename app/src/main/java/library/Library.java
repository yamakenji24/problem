package library;

import java.util.*;

public class Library {
    private List<Book> shelf = new ArrayList<Book>();
    private List<User> users = new ArrayList<User>();
    private BorrowCart borrowCart = new BorrowCart();

    public void printWelcomeMessage(){
        System.out.println("ようこそ図書館システムへ．");
    }
    public void printShelfInfo() {
        for (Book book: shelf) {
            book.printBookInfo();
        }
    }
    public Book createBook(String id, String title, String authors, String publisher, Integer publishYear) {
        Book book = new Book();
        book.setBook(id, title, authors, publisher, publishYear);
        return book;
    }

    public User createUser(String id, String name) {
        User user = new User(id, name);
        borrowCart.setUser(user);
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
    public void startBrowsing() {
        this.printShelfInfo();
        // 仮でid=2の本をレンタルすることにする
        // 後でリダイレクトで入力できるか確認する
        Boolean success = this.borrowBook("2");
        if (success) {
            System.out.println("レンタルに成功しました");
        } else {
            System.out.println("本が見つからなかったみたいです");
        }
    }

    public boolean borrowBook(String id) {
        for (Book book: shelf) {
            if (Objects.equals(id, book.getID())) {
                this.borrowCart.borrow(book);
                return true;
            }
        }
        return false;
    }

    public void run() {
        this.printWelcomeMessage();
        this.addBooks();
        this.addUsers();
        this.startBrowsing();
    }
}