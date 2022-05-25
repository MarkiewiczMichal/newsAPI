package pl.zadanie.newsapi.cwiczenie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {


    @GetMapping("/hello")
    public String welcomePage(Model model) {
        return "hello";
    }

    @PostMapping("/hello")
    public String welcomePageSubmit(Model model) {
        return "hello";
    }

}
