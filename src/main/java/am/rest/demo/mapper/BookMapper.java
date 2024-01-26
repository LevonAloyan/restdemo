package am.rest.demo.mapper;

import am.rest.demo.models.dto.BookDto;
import am.rest.demo.models.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);
}
