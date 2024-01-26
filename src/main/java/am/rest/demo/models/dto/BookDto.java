package am.rest.demo.models.dto;

import am.rest.demo.models.entity.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDto {

    private String name;
    private String price;
    @JsonIgnore
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
