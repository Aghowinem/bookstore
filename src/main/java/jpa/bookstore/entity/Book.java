package jpa.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@NamedEntityGraph(name = "loadAuthor", attributeNodes = @NamedAttributeNode("author"))
@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @Transient
    private double discounted;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    public double getDiscounted() {
        return price*.25;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }
    @PostLoad
    private void calcDiscount(){
        this.setDiscounted(price*.25);
    }
}
