package jpa.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
@EntityListeners({AuditingEntityListener.class})
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDate createDate;
    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

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

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public int getBookCount() {
        return bookCount;
    }

    @PostLoad
    private void calcDiscount(){
        this.setDiscounted(price*.25);
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
}
