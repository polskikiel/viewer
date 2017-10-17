package newsheetviewer.viewer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String mainSite() {
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
