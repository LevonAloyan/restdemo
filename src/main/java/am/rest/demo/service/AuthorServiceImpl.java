package am.rest.demo.service;

import am.rest.demo.exception.ResourceNotFoundException;
import am.rest.demo.mapper.AuthorMapper;
import am.rest.demo.mapper.BookMapper;
import am.rest.demo.models.dto.AuthorDto;
import am.rest.demo.models.entity.Author;
import am.rest.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();


//        for (Author author : authors) {
//            AuthorDto authorDto = new AuthorDto();
//            authorDto.setId(author.getId());
//            authorDto.setName(author.getName());
//            authorDto.setSurname(author.getSurname());
//            authorDto.setAge(author.getAge());
//            authorDtoList.add(authorDto);
//        }

        return authorMapper.toDtoList(authors);
    }

    @Override
    public AuthorDto getAuthorById(int id) {
        Author author = authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        //        AuthorDto authorDto = new AuthorDto();
//        authorDto.setName(author.getName());
//        authorDto.setSurname(author.getSurname());
//        authorDto.setAge(author.getAge());
        return authorMapper.toDto(author);
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto addAuthor(AuthorDto author) {
        Author authorEntity = authorMapper.toEntity(author);
//        Author authorEntity = new Author();
//        authorEntity.setName(author.getName());
//        authorEntity.setSurname(author.getSurname());
//        authorEntity.setAge(author.getAge());
        Author save = authorRepository.save(authorEntity);
        //        AuthorDto authorDto = new AuthorDto();
//        authorDto.setName(save.getName());
//        authorDto.setSurname(save.getSurname());
//        authorDto.setAge(save.getAge());
        return authorMapper.toDto(save);
    }
}
