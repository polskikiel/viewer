package newsheetviewer.viewer.services;

import lombok.AllArgsConstructor;
import newsheetviewer.viewer.compontents.MySession;
import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MySessionServicesImpl implements MySessionServices {
    MySession mySession;

    public void addAuthorToSession(AuthorDto authorDto) {
        List<AuthorDto> authorDtoList = mySession.getVisitedAuthors();
        authorDtoList.add(authorDto);
        mySession.setVisitedAuthors(authorDtoList);
    }

    public void addNewsToSession(NewsDto newsDto) {
        List<NewsDto> newsDtos = mySession.getVisitedNews();
        newsDtos.add(newsDto);
        mySession.setVisitedNews(newsDtos);
    }

    public void setCompanies(List<CompaniesDto> companies) {
        mySession.setCompaniesDto(companies);
    }

    public void addArticleToSession(ArticleDto articleDto) {
        List<ArticleDto> articleDtos = mySession.getVisitedArticles();
        articleDtos.add(articleDto);
        mySession.setVisitedArticles(articleDtos);
    }

    public boolean isContainsCompanies() {
        if(mySession.getCompaniesDto() == null)
            return false;

        return true;
    }

    public boolean isContainsNews(String company) {
        return mySession.getVisitedNews().stream().anyMatch(newsDto -> newsDto.getCompany().equals(company));
    }

    public boolean isContainsAuthor(String name) {
        return mySession.getVisitedAuthors().stream().anyMatch(authorDto -> authorDto.getName().equals(name));
    }
}
