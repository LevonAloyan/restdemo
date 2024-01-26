package am.rest.demo.controller;


import am.rest.demo.models.dto.BookDto;
import am.rest.demo.models.response.BookResponse;
import am.rest.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<BookResponse> getAllBooks() {
        return ResponseEntity.ok(new BookResponse(bookService.getAllBooks()));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getAllBookById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(bookService.getAllBookById(id));
    }

    @GetMapping("/books/author/{id}")
    public ResponseEntity<BookResponse> getBooksByAuthorId(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(new BookResponse(bookService.getBooksByAuthorId(id)));
    }

    @DeleteMapping("/books/{id}")
    public void deleteAuthorById(@PathVariable(name = "id") int id) {
        bookService.deleteAuthorById(id);
    }

    @PostMapping("/books/author/{id}")
    public ResponseEntity<BookDto> addBookByAuthorId(@RequestBody BookDto book, @PathVariable(name = "id") int id) {
        return ResponseEntity.ok(bookService.addBookByAuthorId(book, id));
    }
}
