package jpa.bookstore.service;

import jpa.bookstore.entity.Author;
import jpa.bookstore.repository.AuthorReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {


    @Autowired
    private AuthorReps authorReps;


    public Author findById(int id){

        return authorReps.findById(id).orElseThrow();
    }

    public List<Author> findAll(){
        return authorReps.findAll();
    }

    public Author insert(Author author){
        return authorReps.save(author);
    }

    public List<Author> bulkInsert(List<Author>  author){
        return authorReps.saveAll(author);
    }

    public Author update(Author entity){
        Author author = findById(entity.getId());
        author.setName(author.getName());
        return authorReps.save(author);
    }

    public void DeleteById(int id){
        System.out.println("#" + id +" has been deleted!");
        authorReps.deleteById(id);
    }
}
