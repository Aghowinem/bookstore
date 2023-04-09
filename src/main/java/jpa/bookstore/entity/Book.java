package jpa.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jpa.bookstore.base.BaseEntity;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NamedEntityGraph(name = "loadAuthor", attributeNodes = @NamedAttributeNode("author"))
@Entity

@Table(name = "books")
public class Book extends BaseEntity<Integer> {

    private String name;
    private double price;

    @Transient
    private double discounted;

    @Formula("(select count(*) from books book where book.author_id = id)")
    private int bookCount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discounted=" + discounted +
                ", bookCount=" + bookCount +
                ", author=" + author +
                '}';
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }


    public double getDiscounted() {
        return price*.25;
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

    public int getBookCount() {
        return bookCount;
    }

    @PostLoad
    private void calcDiscount(){
        this.setDiscounted(price*.25);
    }

}
