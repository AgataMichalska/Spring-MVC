package pl.akademiakodu.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity                 // w pom.xml dependency
@Table(name = "book")   // parametrem powinna być nazwa tabeli
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "AUTHOR")
    @NotNull
    @NotEmpty(message = "Author name cannot be empty.")
    private String author;

    @Column(name = "TITLE")
    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Title size cannot be less than 2.")
    private String title;

    @Column(name = "PRICE")
    @Digits(integer = 4, fraction = 2, message = "Price must contain max.4 numbers and 2 fraction.")
    @Min(1)
    private double price;

    @Column(name = "DETAILS")
    private String details;

    public Book() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                '}';
    }
}