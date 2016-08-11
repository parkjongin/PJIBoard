package com.pji.article;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository()
public class ArticleDAO extends SqlMapClientDaoSupport{


	private HashMap<Integer, Article> articleList;

	public ArticleDAO(){
		this.articleList = new HashMap<Integer, Article>();
	}
	
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
	
	public void insertArticle(Article article){
		
		this.getSqlMapClientTemplate().insert("ArticleDAO.insertArticle", article);
	}
	
	public HashMap<Integer, Article> getArticleList(){
		return this.articleList;
	}
	
	public void setArticleList(int key, Article article){
		this.articleList.get(key).setAuthor(article.getAuthor());
		this.articleList.get(key).setContent(article.getContent());
	}
	
}
