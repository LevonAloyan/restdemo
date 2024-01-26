package am.rest.demo.mapper;

import am.rest.demo.models.dto.AuthorDto;
import am.rest.demo.models.entity.Author;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "identificator", source = "id")
    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList (List<Author> authors);

    @Mapping(target = "id", source = "identificator")
    Author toEntity(AuthorDto authorDto);
}
