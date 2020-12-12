package com.mgrapp.GrzegorzDawidek.mgrapp.web;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelmetsWoGController {

    @Autowired
    private ArticlesService articlesService;

    @RequestMapping("/helmetswithoutgoggles")
    public String items(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "helmetswithoutgoggles";
    }
}
