package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/")
	public ModelAndView tweets(String keyword) {
		System.out.println(keyword);
		ArrayList<String> tweets = TweetManager.getTweets(keyword);
		ModelAndView mv=new ModelAndView();
		mv.addObject("tweets", tweets);
		mv.addObject("keyword", keyword);
		mv.setViewName("home.jsp");
		System.out.println(tweets);
		return mv;
	}
}