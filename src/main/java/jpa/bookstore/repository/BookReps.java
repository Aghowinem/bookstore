package jpa.bookstore.repository;

import jpa.bookstore.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookReps extends JpaRepository<Book, Integer> {

    @Override
//    @EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Integer integer);
}
