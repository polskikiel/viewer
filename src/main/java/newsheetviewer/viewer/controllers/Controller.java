package newsheetviewer.viewer.controllers;

import lombok.AllArgsConstructor;
import newsheetviewer.viewer.dto.CompaniesDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    RestTemplate restTemplate;

    private String url = "http://localhost:8080/";

    @GetMapping("/")
    public String mainSite(Model model) {
        restTemplate.getForObject(url + "company", CompaniesDto.class, this);
        return "main";
    }

    @GetMapping("/articles")
    public String allArticles(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page) {

        return "articles";
    }

    @GetMapping("/articles/top")
    public String getTopArticles() {
        return "topArticles";
    }

    @GetMapping("/company/{company}")
    public String getNewsFromCompany(@PathVariable("company") String company) {
        return "company";
    }
    @GetMapping("/company/{company}/article/{id}")
    public String getArticlesFromCompany(@PathVariable("company") String company,
                                         @PathVariable("id") Integer page) {
        return "article";
    }

}
