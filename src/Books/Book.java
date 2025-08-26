package Books;

public class Book {
    private int id;
    private String title;
    private String authors;
    private String description;
    private String category;
    private String publisher;
    private float price; // using USD
    private String publishMonth; // Publishing date (Month)
    private String publishYear;  // Publishing date (Year)

    public Book(int id, String title, String authors, String description, String category, String publisher, float price, String publishMonth,String publishYear){
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

    public int getId() {
        return id;
    }

    public String getDetails(){
        return String.format("Id: %d\nTitle: %s\nAuthors: %s\nDescription: %s\nCategory: %s\nPublisher: %s\nPrice: $%.2f\nDate: %s %s\n",
                id, title, authors, description, category,
                publisher, price, publishMonth, publishYear);
    }

    public String getTitleAndAuthor(){
        return String.format("%s %s", title, authors);
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

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nTitle: %s\nAuthors: %s\nDescription: %s\nCategory: %s\nPublisher: %s\nPrice: $%.2f\nDate: %s %s\n",
                id, title, authors, description, category,
                publisher, price, publishMonth, publishYear);
    }
}
