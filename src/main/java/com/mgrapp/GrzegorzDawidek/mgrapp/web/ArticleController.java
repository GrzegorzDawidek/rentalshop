package com.mgrapp.GrzegorzDawidek.mgrapp.web;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Articles;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.Reservation;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.User;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.dto.ReserveArticleDto;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.ReservationRepository;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.UserRepository;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.ArticlesService;
import com.mgrapp.GrzegorzDawidek.mgrapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("articles") Articles articles) {
        articlesService.save(articles);
        return "redirect:/newarticle";
    }

    @RequestMapping("/newarticle")
    public String newProduct(Model model) {
        Articles articles = new Articles();
        model.addAttribute("articles", articles);
        return "newarticle";
    }

    @RequestMapping(value = "/reservedarticle", method = RequestMethod.POST)
    public void saveDateReservation(@ModelAttribute("reservation") ReserveArticleDto reserveArticleDto, SecurityContextHolder securityContextHolder) {
//        System.out.println(reserveArticleDto.getArticleid());
//        System.out.println(reserveArticleDto.getReservedate());
        Object principal = securityContextHolder.getContext().getAuthentication().getPrincipal();
       if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            User user = userRepository.findByEmail(username);

           Reservation reservation = new Reservation(
                   reserveArticleDto.getReservedate(),
                   Long.parseLong(reserveArticleDto.getArticleid()),
                   user.getId()
           );
           reservationRepository.save(reservation);
        }

//        Reservation reservation = new Reservation(
//                reserveArticleDto.getReservedate(),
//                Long.parseLong(reserveArticleDto.getArticleid())
//        );
//        reservationRepository.save(reservation);
//        model.addAttribute("articles", articles);
//        return "newarticle";
    }

    @RequestMapping("/boots")
    public String addItemBoots(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "boots";
    }

    @RequestMapping("/goggles")
    public String addItemGoogles(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "goggles";
    }

    @RequestMapping("/skis")
    public String addItemSkis(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "skis";
    }

    @RequestMapping("/snowboard")
    public String addItemSnowboard(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "snowboard";
    }

    @RequestMapping("/sticks")
    public String addItemSticks(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "sticks";
    }

    @RequestMapping("/wintersuit")
    public String addItemWintersuit(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "wintersuit";
    }

    @RequestMapping("/helmetswithgoggles")
    public String addItemHelmetsWithGoggles(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "helmetswithgoggles";
    }

    @RequestMapping("/helmetswithoutgoggles")
    public String addItemHelmetsWithoutGoggles(Model model) {
        List<Articles> listArticles = articlesService.listAll();
        model.addAttribute("listArticles", listArticles);
        return "helmetswithoutgoggles";
    }

}
