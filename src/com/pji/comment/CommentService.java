package com.pji.comment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CommentService {

	@Autowired
	CommentDAO commentDAO;
	
	public CommentService(){

	}
	
	public ModelAndView commentService(Comment commentObj){
	    Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.format(d);

		

		if(commentObj.getTarget().equals("NULL")){
			commentObj.setSeq(1);
			commentObj.setCount(1);
			commentDAO.insertComment(commentObj);
		}
		else{
			commentDAO.insertReply(commentObj);
		}
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("message");
		JSONObject json = new JSONObject();
		json.put("name", commentObj.getName());
		json.put("comment", commentObj.getContent());
		json.put("groupID", commentObj.getCommentGroupId());
		json.put("date", commentObj.getDate());
		mv.addObject("message", json.toString()) ;
		
		return mv;
	}
	

	
}
