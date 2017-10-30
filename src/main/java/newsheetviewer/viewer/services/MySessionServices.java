package newsheetviewer.viewer.services;

import newsheetviewer.viewer.compontents.MySession;
import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;

import java.util.List;

public interface MySessionServices {

    List<CompaniesDto> getByLangAndCategory(String lang, String cat);

    String getLanguage(String lang);

    void addAuthorToSession(AuthorDto authorDto);

    void addNewsToSession(NewsDto newsDto);

    void setCompanies(List<CompaniesDto> companies);

    void addArticleToSession(ArticleDto articleDto);

    boolean isContainsNews(String company);

    boolean isContainsAuthor(String name);

    boolean isContainsCompanies();

    MySession getSession();
}
