package am.rest.demo.models.response;

import am.rest.demo.models.dto.BookDto;

import java.util.List;

public class BookResponse {
    private List<BookDto> bookList;

    public BookResponse(List<BookDto> bookList) {
        this.bookList = bookList;
    }

    public List<BookDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDto> bookList) {
        this.bookList = bookList;
    }
}

