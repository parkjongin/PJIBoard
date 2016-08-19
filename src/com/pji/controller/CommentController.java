package com.pji.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pji.comment.Comment;
import com.pji.comment.CommentDAO;
import com.pji.comment.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView createComment(@ModelAttribute Comment commentObj){

		return commentService.commentService(commentObj);
	}
	
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ModelAndView createCommentGet(HttpServletRequest request){
		
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("message");
		mv.addObject("message", "get");
		
		
		
		//mv.addObject("article", article);
		//mv.setViewName("articleView");
		return mv;
	}
}
