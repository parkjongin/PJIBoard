package com.pji.comment;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository()
public class CommentDAO extends SqlMapClientDaoSupport{

/*
	
	public ArrayList<Article> selectArticleList(){
	 
		ArrayList<Article> articleList = null;


		articleList = (ArrayList<Article>)this.getSqlMapClientTemplate().queryForList("ArticleDAO.getArticleList");
		
		for(int i=0; i<articleList.size(); i++){
			this.articleList.put(articleList.get(i).getID(), articleList.get(i));
		}

		return articleList;
	}
	
	public void updateArticle(Article article){
		this.getSqlMapClientTemplate().update("ArticleDAO.updateArticle", article);
	}
	
	*/
	
	public void insertComment(Comment comment){
		
		this.getSqlMapClientTemplate().insert("CommentDAO.insertCommentGroup", comment);
		Integer groupid = (Integer) this.getSqlMapClientTemplate().queryForObject("CommentDAO.getRecentCommentGroupID");
		System.out.println("groupid : " + groupid);
		comment.setCommentGroupId(groupid);
		this.getSqlMapClientTemplate().insert("CommentDAO.insertComment", comment);
	}
	
	public ArrayList<Comment> getCommentList(Integer articleID){
		ArrayList<Comment> commentList = (ArrayList<Comment>) this.getSqlMapClientTemplate().queryForList("CommentDAO.getCommentList", articleID);
		return commentList;
		
	}
	
	public void insertReply(Comment comment){
		System.out.println("comment GroupID : " + comment.getCommentGroupId());
		Integer maxseq = (Integer) this.getSqlMapClientTemplate().queryForObject("CommentDAO.getMaxSeq", comment);
		System.out.println("maxseq : " + maxseq);
		comment.setSeq(maxseq+1);
		this.getSqlMapClientTemplate().insert("CommentDAO.insertComment", comment);
	}

	
}
