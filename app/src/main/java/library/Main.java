package library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.printWelcomeMessage();

        lib.addUsers();
        lib.addBooks();
        lib.printShelfInfo();

        lib.borrowBook("2");
    }
}