package newsheetviewer.viewer.services;

import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;

import java.util.List;

public interface MySessionServices {
    void addAuthorToSession(AuthorDto authorDto);

    void addNewsToSession(NewsDto newsDto);

    void setCompanies(List<CompaniesDto> companies);

    void addArticleToSession(ArticleDto articleDto);

    boolean isContainsNews(String company);

    boolean isContainsAuthor(String name);

    boolean isContainsCompanies();
}
