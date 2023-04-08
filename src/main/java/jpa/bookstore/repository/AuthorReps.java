package jpa.bookstore.repository;

import jpa.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorReps extends JpaRepository<Author, Integer> {
}
