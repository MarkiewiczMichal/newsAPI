package pl.zadanie.newsapi.cwiczenie.controller;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.zadanie.newsapi.cwiczenie.NewsGenerator;

@RestController
public class HelloController {

    private final static NewsGenerator HELPER = new NewsGenerator();

    @GetMapping("/dupa/{kindofNews}")
    public String dupa(@PathVariable("kindofNews") String kindofNews ) {
       HELPER.somethingNews(kindofNews);
        return HELPER.getWantedNews() + "Kliknij F5";
    }

    @GetMapping("/kupa/{kindofNews}")
    public String kupa(@PathVariable("kindofNews") String kindofNews) {
        HELPER.somethingNews(kindofNews);
        return HELPER.getArticles()+"______________________"+"Kolejny NEWS kliknij F5";
    }
}
