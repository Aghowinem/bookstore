package jpa.bookstore.controller;

import jpa.bookstore.entity.Author;
import jpa.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(authorService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Author author){
        return ResponseEntity.ok(authorService.insert(author));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Author entity){
        return ResponseEntity.ok(authorService.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable int id){
        authorService.DeleteById(id);
        return ResponseEntity.ok(null);
    }
}
