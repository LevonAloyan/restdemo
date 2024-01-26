package am.rest.demo.service;

import am.rest.demo.exception.ResourceNotFoundException;
import am.rest.demo.mapper.BookMapper;
import am.rest.demo.models.dto.BookDto;
import am.rest.demo.models.entity.Author;
import am.rest.demo.models.entity.Book;
import am.rest.demo.repository.AuthorRepository;
import am.rest.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            BookDto bookDto = bookMapper.toDto(book);
//            BookDto bookDto = new BookDto();
//            bookDto.setName(book.getName());
//            bookDto.setPrice(book.getPrice());
//            bookDto.setAuthor(book.getAuthor());
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    @Override
    public BookDto getAllBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        //        BookDto bookDto = new BookDto();
//        bookDto.setName(book.getName());
//        bookDto.setPrice(book.getPrice());
//        bookDto.setAuthor(book.getAuthor());
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getBooksByAuthorId(int id) {
        Author author = authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        List<Book> bookList = bookRepository.findAllByAuthor(author);
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : bookList) {
            BookDto bookDto = bookMapper.toDto(book);
//            BookDto bookDto = new BookDto();
//            bookDto.setName(book.getName());
//            bookDto.setPrice(book.getPrice());
//            bookDto.setAuthor(book.getAuthor());
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    @Override
    public void deleteAuthorById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto addBookByAuthorId(BookDto book, int id) {
        Author author = authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        Book bookEntity = bookMapper.toEntity(book);
//        Book bookEntity = new Book();
//        bookEntity.setName(book.getName());
//        bookEntity.setPrice(book.getPrice());
//        bookEntity.setAuthor(author);
        Book save = bookRepository.save(bookEntity);
//        BookDto bookDto = new BookDto();
//        bookDto.setName(save.getName());
//        bookDto.setPrice(save.getPrice());
//        bookDto.setAuthor(save.getAuthor());
        return bookMapper.toDto(save);

    }
}
