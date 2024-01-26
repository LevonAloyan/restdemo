package am.rest.demo.controller;

import am.rest.demo.models.dto.AuthorDto;
import am.rest.demo.models.response.AuthorResponse;
import am.rest.demo.service.AuthorService;
import io.swagger.annotations.ApiOperation;
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
public class AuthorController {
    // GET - get resource
    // POST - create new resource
    // PUT - Update existing resource
    // DELETE - Delete resource
    // PATCH - Partial update

    private final AuthorService authorService;

    public AuthorController (AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ApiOperation("Get all authors list from database")
    public ResponseEntity<AuthorResponse> getAllAuthors() {
        return ResponseEntity.ok(new AuthorResponse(authorService.getAllAuthors()));
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthorById(@PathVariable(name = "id") int id) {
        authorService.deleteAuthorById(id);
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto author) {
        AuthorDto authorDto = authorService.addAuthor(author);
        return ResponseEntity.ok(authorDto);
    }
}
