package newsheetviewer.viewer.services;

import lombok.Getter;
import newsheetviewer.viewer.compontents.MySession;
import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MySessionServicesImpl implements MySessionServices {
    MySession mySession;

    public MySessionServicesImpl(MySession mySession) {
        this.mySession = mySession;
    }

    @Getter
    private String[] categories = {"General", "Sport", "Technology", "Business", "Politics", "Music",
            "Science/Nature", "Entertainment"};
    @Getter
    private String[] languages = {"English", "Deutsch"};

    @Override
    public List<CompaniesDto> getByLangAndCategory(String lang, String cat) {

        if (lang != null || cat != null) {
            if (lang != null && cat != null) {
                return this.mySession.getCompanies().stream().
                        filter(companiesDto -> companiesDto.getLanguage().equals(lang) && companiesDto.getCategory().equals(cat.toLowerCase())).
                        collect(Collectors.toList());
            }
            if (cat != null) {
                return this.mySession.getCompanies().stream().
                        filter(companiesDto -> companiesDto.getCategory().equals(cat.toLowerCase())).
                        collect(Collectors.toList());
            }
            return this.mySession.getCompanies().stream().
                    filter(companiesDto -> companiesDto.getLanguage().equals(lang)).
                    collect(Collectors.toList());

        }
        return this.mySession.getCompanies();
    }

    @Override
    public String getLanguage(String lang) {
        try {
            if (lang.equals("English")) {
                return "en";
            } else {
                return "de";
            }
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public void addAuthorToSession(AuthorDto authorDto) {
        List<AuthorDto> authorDtoList = mySession.getVisitedAuthors();
        authorDtoList.add(authorDto);
        mySession.setVisitedAuthors(authorDtoList);
    }

    @Override
    public void addNewsToSession(NewsDto newsDto) {
        List<NewsDto> newsDtos = mySession.getVisitedNews();
        newsDtos.add(newsDto);
        mySession.setVisitedNews(newsDtos);
    }

    @Override
    public void setCompanies(List<CompaniesDto> companies) {
        mySession.setCompanies(companies);
    }

    @Override
    public void addArticleToSession(ArticleDto articleDto) {
        List<ArticleDto> articleDtos = mySession.getVisitedArticles();
        articleDtos.add(articleDto);
        mySession.setVisitedArticles(articleDtos);
    }

    @Override
    public MySession getSession() {
        return mySession;
    }

    @Override
    public boolean isContainsCompanies() {
        if (mySession.getCompanies() == null)
            return false;

        return true;
    }

    @Override
    public boolean isContainsNews(String company) {
        return mySession.getVisitedNews().stream().anyMatch(newsDto -> newsDto.getCompany().equals(company));
    }

    @Override
    public boolean isContainsAuthor(String name) {
        return mySession.getVisitedAuthors().stream().anyMatch(authorDto -> authorDto.getName().equals(name));
    }


}
