package com.pji.article;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pji.comment.Comment;
import com.pji.comment.CommentDAO;

@Service
public class ArticleService {
	
	@Autowired
	ArticleDAO articleDAO;
	@Autowired
	CommentDAO commentDAO;

	public ModelAndView articleService(int id){
		
		
		ModelAndView mv = new ModelAndView();
		

		Article article = null;	
		article = articleDAO.getArticleList().get(id);
		if(article != null){
			if(article.getContent().equals("NULL")){
				
	
				ArticleParser articleParser = new ArticleParser();
				articleParser.startPasing(articleDAO.getArticleList().get(id).getLink());
				
				article.setAuthor(articleParser.getAuthor());
				article.setContent(articleParser.getContent());
				articleDAO.setArticleList(id, article);
				articleDAO.updateArticle(article);
			}
		}
		



		ArrayList<Comment> commentList = commentDAO.getCommentList(id);
		
		Integer tempGroupID = -1;
		
		if(commentList != null){
			for(int i=0; i<commentList.size(); i++){
		        String html ="";
				if(tempGroupID.intValue() != commentList.get(i).getCommentGroupId()){
					System.out.println(commentList.get(i).getCommentGroupId());
					tempGroupID = commentList.get(i).getCommentGroupId();
			        if(i > 0) html += "</div></li></ul>";
			        html += "       	<br><ul class='media-list'><li class='media'>         <div class='media-left'>";
			        html += " <a href='#'><img class='media-object' src='http://megaicons.net/static/img/icons_sizes/207/499/64/angry-bird-blue-icon.png'></a></div>";
			        html +=         "<div class='media-body' id='";
			        html += commentList.get(i).getCommentGroupId() + "'><h4 class='media-heading'>";
			        html += commentList.get(i).getName() + "</h4>";
			        html +=  commentList.get(i).getContent() + "<br>" + commentList.get(i).getDate() + "<br>";
			        html += "<button type='button' class='btn btn-success' onClick='toggleReplyBtn(";
			        html += article.getID() + "," + commentList.get(i).getCommentGroupId() + ")'>답글</button><br>";
				}
				else{
						   html = "	<div class='media'>	<div class='media-left'> <a href='#'> <img class='media-object' src='http://megaicons.net/static/img/icons_sizes/207/499/64/angry-bird-blue-icon.png'> </a>		          	</div>";
			        	   html += "<div class='media-body'> <h4 class='media-heading'>" + commentList.get(i).getName() + "</h4>";
	       				   html += commentList.get(i).getContent() + " <br>" +  commentList.get(i).getDate() + "	<br></div></div>";
				}
				if(i == commentList.size() - 1){
					html += "</div></li></ul>";
				}
				
				commentList.get(i).setCommentHTML(html);
			}
		}
		
		mv.addObject("article", article);
		mv.addObject("commentList",commentList);
		mv.setViewName("articleView");
		
		return mv;
	}
}
