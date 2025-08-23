package Books;

public class Book {
    private int id;
    private String title;
    private String authors;
    private String description;
    private String category;
    private String publisher;
    private String price; // using USD
    private String publishMonth; // Publishing date (Month)
    private String publishYear;  // Publishing date (Year)

    public Book(int id, String title, String authors, String description, String category, String publisher, String price, String publishMonth,String publishYear){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.category = category;
        this.publisher = publisher;
        this.price = price;
        this.publishMonth = publishMonth;
        this.publishYear = publishYear;
    }

    public long getId() {
        return id;
    }

    public String getDetails(){
        return String.format("Title: %s\nAuthors: %s\nDescription: %s\nCategory: %s\nPublisher: %s\nPrice: $%s\nDate: %s %s",
                title, authors, description, category,
                publisher, price, publishMonth, publishYear);
    }

    public String getDetailsWithId(){
        return String.format("Id: %d\nTitle: %s\nAuthors: %s\nDescription: %s\nCategory: %s\nPublisher: %s\nPrice: $%s\nDate: %s %s",
                id, title, authors, description, category,
                publisher, price, publishMonth, publishYear);
    }
    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s, $%s, %s %s",
                id, title, authors, description, category,
                publisher, price, publishMonth, publishYear);
    }
}
