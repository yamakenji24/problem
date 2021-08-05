package library;

interface InterfaceBook {
    public void setBook(String id, String title, String authors, String publisher, Integer publishYear);
    public void printBookInfo();
    public String getID();
    public String getTitle();
}

public class Book implements InterfaceBook {
    private String id;
    private String title;
    private String authors;
    private String publisher;
    private Integer publishYear;

    public void setBook(String id, String title, String authors, String publisher, Integer publishYear) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }

    public void printBookInfo() {
        System.out.printf("%s (%s) %s, %d%n",
                title, authors, publisher, publishYear);
    }
    public String getID() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
}