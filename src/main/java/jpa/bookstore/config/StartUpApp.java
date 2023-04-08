package jpa.bookstore.config;

import jpa.bookstore.entity.Author;
import jpa.bookstore.entity.Book;
import jpa.bookstore.service.AuthorService;
import jpa.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class StartUpApp implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setName("Ali");

        Author author2 = new Author();
        author2.setName("Mohammed");

        Author author3 = new Author();
        author3.setName("Saleh");

        authorService.bulkInsert(Arrays.asList(author1,author2,author3));

        Book book1 = new Book();
        book1.setName("Java JPA");
        book1.setPrice(200);
        book1.setAuthor(authorService.findById(1));

        Book book2 = new Book();
        book2.setName("Database Mysql");
        book2.setPrice(300);
        book2.setAuthor(authorService.findById(1));

        Book book3 = new Book();
        book3.setName("Python");
        book3.setPrice(120);
        book3.setAuthor(authorService.findById(1));

        bookService.BulkInsert(Arrays.asList(book1,book2,book3));

    }
}
