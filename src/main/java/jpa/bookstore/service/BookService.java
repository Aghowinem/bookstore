package jpa.bookstore.service;

import jpa.bookstore.entity.Book;
import jpa.bookstore.repository.BookReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookReps bookReps;
    public Book findById(int id){

        return bookReps.findById(id).orElseThrow();
    }

    public List<Book> findAll(){
        return bookReps.findAll();
    }

    public Book insert(Book book){
        return bookReps.save(book);
    }
    public List<Book> BulkInsert(List<Book> book){
        return bookReps.saveAll(book);
    }

    public Book update(Book entity){
        Book book = findById(entity.getId());
        book.setName(book.getName());
        return bookReps.save(book);
    }

    public void DeleteById(int id){
        System.out.println("#" + id +" has been deleted!");
        bookReps.deleteById(id);
    }
}
