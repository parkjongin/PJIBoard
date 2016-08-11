package com.pji.rss;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pji.article.ArticleDAO;

@Service
public class RssFeedService {

	@Autowired
	private ArticleDAO articleDAO;

	
	private RssFeedThread rssFeedThread = null;

	@PostConstruct
	public void initRssThread(){
		System.out.println("runRssFeedThread");
		RssFeedThread rssFeedThread = new RssFeedThread(articleDAO);
		rssFeedThread.start();
	}
	
	@PreDestroy
	public void destroyRssThread(){
		rssFeedThread.interrupt();
	}
}
