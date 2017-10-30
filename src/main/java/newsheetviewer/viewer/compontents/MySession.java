package newsheetviewer.viewer.compontents;

import lombok.Getter;
import lombok.Setter;
import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class MySession {
    List<NewsDto> visitedNews;
    List<AuthorDto> visitedAuthors;
    List<ArticleDto> visitedArticles;
    List<CompaniesDto> companies;

    @PostConstruct
    public void init() {
        visitedArticles = new ArrayList<>();
        visitedAuthors = new ArrayList<>();
        visitedNews = new ArrayList<>();
    }
}
