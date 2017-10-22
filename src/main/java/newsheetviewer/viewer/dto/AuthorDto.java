package newsheetviewer.viewer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthorDto {
    String name;
    String company;
    int likes;
    int articlesNr;

    List<ArticleDto> articles;

}
