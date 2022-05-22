package pl.zadanie.newsapi.cwiczenie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.zadanie.newsapi.cwiczenie.NewsGenerator;

@RestController
public class HelloController {

    private final static NewsGenerator HELPER = new NewsGenerator();


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dupa/{kindofNews}")
    public String dupa(@PathVariable("kindofNews") String kindofNews ) {
        HELPER.somethingNews(kindofNews);
        return HELPER.getWantedNews() + "dupa blada";
    }
}
