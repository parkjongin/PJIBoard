package com.pji.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pji.article.*;
import com.pji.comment.Comment;
import com.pji.comment.CommentDAO;

@Controller
public class ArticleViewController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/articleView/{id}")
	public ModelAndView viewArticle(@PathVariable Integer id){
		
		return articleService.articleService(id);
	}
}
