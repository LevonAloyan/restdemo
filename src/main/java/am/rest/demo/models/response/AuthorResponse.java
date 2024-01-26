package am.rest.demo.models.response;

import am.rest.demo.models.dto.AuthorDto;

import java.util.List;

public class AuthorResponse {

    private List<AuthorDto> authorList;

    public AuthorResponse(List<AuthorDto> authorList) {
        this.authorList = authorList;
    }

    public List<AuthorDto> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorDto> authorList) {
        this.authorList = authorList;
    }
}
