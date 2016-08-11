package com.pji.article;

public class Article {

	Integer	id;
	String	title;
	String	author;
	String	link;
	String	description;
	String	content;
	String	date;
	
	public Article(){
		this.id = null;
		this.title = "NULL";
		this.author = "NULL";
		this.link = "NULL";
		this.description = "NULL";
		this.content = "NULL";
		this.date = "NULL";
	}
	
	public void setID(Integer id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public void setLink(String link){
		this.link = link;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setContent(String content){
		this.content = content;
	}
	public void setDate(String date){
		this.date = date;
	}
	
	public Integer getID(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAuthor(){
		return this.author;
	}
	public String getLink(){
		return this.link;
	}
	public String getDescription(){
		return this.description;
	}
	public String getContent(){
		return this.content;
	}
	public String getDate(){
		return this.date;
	}
	
}
