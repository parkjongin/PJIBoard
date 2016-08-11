package com.pji.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pji.comment.Comment;
import com.pji.comment.CommentDAO;

@Controller
public class CommentController {
	@Autowired
	private CommentDAO commentDAO;
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView createComment(HttpServletRequest request){
		
	    Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.format(d);
		
		String articleID = request.getParameter("articleID");
		String comment = request.getParameter("comment");
		String name = request.getParameter("name");
		String target = request.getParameter("target");

		
		System.out.println(articleID);
		System.out.println(comment);
		System.out.println(name);
		System.out.println(target);
		
		Comment commentObj = new Comment();
		commentObj.setArticleID(Integer.parseInt(articleID));
		commentObj.setContent(comment);
		commentObj.setName(name);
		System.out.println(sdf.format(d).toString());
		commentObj.setDate(sdf.format(d).toString());

		

		if(target.equals("NULL")){
			commentObj.setSeq(1);
			commentObj.setCount(1);
			commentDAO.insertComment(commentObj);
		}
		else{
			String groupID = request.getParameter("groupID");
			commentObj.setCommentGroupId(Integer.parseInt(groupID));
			commentDAO.insertReply(commentObj);
		}
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("message");
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("comment", comment);
		json.put("groupID", commentObj.getCommentGroupId());
		json.put("date", commentObj.getDate());
		mv.addObject("message", json.toString()) ;
		
		
		
		//mv.addObject("article", article);
		//mv.setViewName("articleView");
		return mv;
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
