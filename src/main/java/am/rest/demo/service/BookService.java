package am.rest.demo.service;


import am.rest.demo.models.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto getAllBookById(int id);

    List<BookDto> getBooksByAuthorId(int id);

    void deleteAuthorById(int id);

    BookDto addBookByAuthorId(BookDto book, int id);
}
