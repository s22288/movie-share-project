package com.example.movieshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RankingController {
    @GetMapping(value = "/ranking")
    public ModelAndView GetRankingInfo(){
        ModelAndView mv = new ModelAndView("Ranking");
        return mv;
    }
}
