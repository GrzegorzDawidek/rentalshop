package com.mgrapp.GrzegorzDawidek.mgrapp.web;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;


    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("articles") Articles articles) {
        articlesService.save(articles);
        return "redirect:/boots";
    }

    @RequestMapping("/newarticle")
    public String newProduct(Model model) {
        Articles articles = new Articles();
        model.addAttribute("articles", articles);
        return "newarticle";
    }


}
