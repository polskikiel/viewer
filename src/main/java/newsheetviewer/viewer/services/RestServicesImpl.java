package newsheetviewer.viewer.services;

import newsheetviewer.viewer.dto.ArticleDto;
import newsheetviewer.viewer.dto.AuthorDto;
import newsheetviewer.viewer.dto.CompaniesDto;
import newsheetviewer.viewer.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestServicesImpl implements RestService {
    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://localhost:8080/";

    @Override
    public CompaniesDto getCompanies() {
        return restTemplate.exchange(url + "company",
                HttpMethod.GET, HttpEntity.EMPTY, CompaniesDto.class).getBody();
    }

    @Override
    public NewsDto getNews(String company) {
        return restTemplate.exchange(url + "company/" + company,
                HttpMethod.GET, HttpEntity.EMPTY, NewsDto.class).getBody();
    }

    @Override
    public AuthorDto getAuthor(String name) {
        return restTemplate.exchange(url + "author/" + name,
                HttpMethod.GET, HttpEntity.EMPTY, AuthorDto.class).getBody();
    }

    @Override
    public List<AuthorDto> getAuthorsFromCompany(String company) {
        return restTemplate.exchange(url + "company/" + company + "/authors",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<AuthorDto>>() {
                }).getBody();
    }

    @Override
    public List<AuthorDto> getTopAuthors(String by) {
        return restTemplate.exchange(url + "authors/top?by=" + by,
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<AuthorDto>>() {
                }).getBody();
    }

    @Override
    public ArticleDto getFromAuthor(String name) {
        return null;
    }

    @Override
    public List<ArticleDto> bestArticles() {
        return restTemplate.exchange(url + "articles/top",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ArticleDto>>() {
                }).getBody();
    }

    @Override
    public List<NewsDto> getNewsByLanguageOrCategory(String language, String[] cat) {
        return restTemplate.exchange(url + "news?lang=" + language + "&cat=",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<NewsDto>>() {
                }).getBody();
    }

    private String getUrl(String[] cat) {
        String result = "";
        for (String category : cat) {
            if (category != cat[cat.length - 1])
                result += category + ",";
        }
        return result;
    }
}
