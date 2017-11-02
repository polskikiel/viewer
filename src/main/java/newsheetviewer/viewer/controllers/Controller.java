package newsheetviewer.viewer.controllers;

import lombok.AllArgsConstructor;
import newsheetviewer.viewer.services.MySessionServicesImpl;
import newsheetviewer.viewer.services.RestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.ConnectException;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    RestService restService;
    MySessionServicesImpl mySessionServices;


    @GetMapping("/")
    public String mainSite(Model model,
                           @RequestParam(value = "lang", required = false) String lang,
                           @RequestParam(value = "cat", required = false) String categories) {

        model.addAttribute("categories", mySessionServices.getCategories());
        model.addAttribute("languages", mySessionServices.getLanguages());


        if (!mySessionServices.isContainsCompanies() || mySessionServices.getSession().getCompanies().size() == 0) {
            try {
                mySessionServices.setCompanies(restService.getCompanies());
            } catch (ConnectException c) {
                System.out.println("CONNECTION REFUSED");
            }
        }
        model.addAttribute("companies",
                mySessionServices.getByLangAndCategory(
                        mySessionServices.getLanguage(lang), categories));
        return "main";
    }

    @GetMapping("/search")
    @ResponseBody
    public String search(@RequestParam String search, Model model) {
        if (search != null) {
            model.addAttribute("searchInput", search);
        }
        return "main";
    }

    @GetMapping("/articles")
    public String allArticles(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page) {

        return "articles";
    }

    @GetMapping("/authors")
    public String getTopArticles() {
        return "topArticles";
    }

    @GetMapping("/company/{company}")
    public String getNewsFromCompany(@PathVariable("company") String company, Model model) {
        if (!mySessionServices.isContainsNews(company)) {
            mySessionServices.addNewsToSession(restService.getNews(company));
        }
        model.addAttribute("news",
                mySessionServices.getSession().getVisitedNews().stream().
                        filter(newsDto -> newsDto.getCompany().equals(company)).findAny().get());
        return "company";
    }


    @GetMapping("/company/{company}/article/{id}")
    public String getArticlesFromCompany(@PathVariable("company") String company,
                                         @PathVariable("id") Integer page) {
        return "article";
    }

}
