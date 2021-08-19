package library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.printWelcomeMessage();

        lib.addUsers("1", "Yamada");

        lib.addBooks("1", "本のタイトル1", "著者の名前", "出典元", 1997);
        lib.addBooks("2", "本のタイトル1", "著者の名前", "出典元", 1998);
        lib.addBooks("3", "本のタイトル1", "著者の名前", "出典元", 1999);

        lib.printShelfInfo();

        lib.borrowBook("1", "2");
    }
}