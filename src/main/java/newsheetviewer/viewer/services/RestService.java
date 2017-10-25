package newsheetviewer.viewer.services;

import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;

import java.util.List;

/**
 * Created by Majk on 2017-10-21.
 */
public interface RestService {
    List<CompaniesDto> getCompanies();

    NewsDto getNews(String company);

    AuthorDto getAuthor(String name);

    List<AuthorDto> getAuthorsFromCompany(String company);

    List<AuthorDto> getTopAuthors(String by);

    ArticleDto getFromAuthor(String name);

    List<ArticleDto> bestArticles();

    List<NewsDto> getNewsByLanguageOrCategory(String language, String[] cat);

}
