package com.pji.comment;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void insertComment(Comment comment){
		try{
			this.getSqlMapClientTemplate().insert("CommentDAO.insertCommentGroup", comment);
			Integer groupid = (Integer) this.getSqlMapClientTemplate().queryForObject("CommentDAO.getRecentCommentGroupID");
			comment.setCommentGroupId(groupid);
			this.getSqlMapClientTemplate().insert("CommentDAO.insertComment", comment);
		}catch(Exception e){
			System.out.println("insert Comment error");
			throw e;
		}
	}
	
	public ArrayList<Comment> getCommentList(Integer articleID){
		ArrayList<Comment> commentList = (ArrayList<Comment>) this.getSqlMapClientTemplate().queryForList("CommentDAO.getCommentList", articleID);
		return commentList;
		
	}
	//
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void insertReply(Comment comment){
		try{
			Integer maxseq = (Integer) this.getSqlMapClientTemplate().queryForObject("CommentDAO.getMaxSeq", comment);
			comment.setSeq(maxseq+1);
			this.getSqlMapClientTemplate().insert("CommentDAO.insertComment", comment);
		}catch(Exception e){
			System.out.println("insert Reply error");
			throw e;
		}
	}

	
}
