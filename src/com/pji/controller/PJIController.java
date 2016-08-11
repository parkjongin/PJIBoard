package com.pji.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.pji.article.Article;
import com.pji.article.ArticleDAO;
import com.pji.rss.RssFeedThread;

@Controller
public class PJIController {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@RequestMapping("/home")
	public ModelAndView PJIHomeController(){
		ModelAndView mv = new ModelAndView();

		ArrayList<Article> articleList = articleDAO.selectArticleList();
		
		mv.addObject("articles", articleList);
		
		return mv;
	}
}
