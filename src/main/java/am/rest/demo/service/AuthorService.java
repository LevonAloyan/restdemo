package am.rest.demo.service;

import am.rest.demo.models.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(int id);

    void deleteAuthorById(int id);

    AuthorDto addAuthor(AuthorDto author);

}
