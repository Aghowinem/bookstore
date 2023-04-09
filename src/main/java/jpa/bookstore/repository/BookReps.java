package jpa.bookstore.repository;

import jakarta.transaction.Transactional;
import jpa.bookstore.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookReps extends JpaRepository<Book, Integer> {

    @Override
    @EntityGraph(value = "loadAuthor")
    Optional<Book> findById(Integer integer);

    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();

//    @Transactional
//    @Modifying
//    @Query("delete from Book b where b.authors.id = :id")
//    int deleteByAuthorsId(int id);
}
