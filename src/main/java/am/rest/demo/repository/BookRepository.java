package am.rest.demo.repository;

import am.rest.demo.models.entity.Author;
import am.rest.demo.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthor(Author author);
}



// Controller -> Service (Modification, transformation, validation, mapping) -> Repository
