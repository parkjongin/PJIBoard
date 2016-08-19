package com.pji.rss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pji.article.Article;
import com.pji.article.ArticleDAO;

public class RssFeedThread extends Thread{

	private ArticleDAO articleDAO;
	
	RSSReader rssReader = RSSReader.getInstance();
	
	public RssFeedThread(ArticleDAO articleDAO){
		this.articleDAO = articleDAO;
		URL url=null;
		try {
			url = new URL("http://www.cnbc.com/id/15839069/device/rss/rss.html");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rssReader.setURL(url);

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			ArrayList<Article> articleList = rssReader.writeFeed();
			Article article = null;

			
			for(int i=0; i<articleList.size(); i++){
				article = new Article();
				
				article.setTitle(articleList.get(i).getTitle());
				article.setDescription(articleList.get(i).getDescription());
				article.setLink(articleList.get(i).getLink());
				article.setDate(articleList.get(i).getDate());
				
				
				articleDAO.insertArticle(article);
			}
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.interrupt();
			}
		}
	}

}
