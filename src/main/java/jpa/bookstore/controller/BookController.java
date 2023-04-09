package jpa.bookstore.controller;

import jpa.bookstore.entity.Book;
import jpa.bookstore.entity.BookDTO;
import jpa.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Book book = bookService.findById(id);

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());

        dto.setAuthor(book.getAuthor());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Book book){
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable int id){
        bookService.DeleteById(id);
        return ResponseEntity.ok(null);
    }

//    @DeleteMapping("/author/{id}")
//    public ResponseEntity<?> deleteByAuthorId(@PathVariable int id){
//        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
//    }
}
