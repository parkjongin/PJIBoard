package com.pji.comment;

public class Comment {

	Integer GroupID;
	Integer articleID;
	Integer commentID;
	Integer seq;
	Integer count;
	String	content;
	String 	name;
	String	date;
	String	target;
	String	commentHTML;
	
	public Comment(){
		this.GroupID = null;
		this.articleID = null;
		this.commentID = null;
		this.seq = null;
		this.count = null;
		this.content = "NULL";
		this.name = "NULL";
		this.date = "NULL";
		this.target = "NULL";
	}

	public String getCommentHTML(){
		return this.commentHTML;
	}
	
	public void setCommentHTML(String html){
		this.commentHTML = html;
	}
	
	public Integer getCommentGroupId() {
		return GroupID;
	}

	public void setCommentGroupId(Integer commentGroupId) {
		this.GroupID = commentGroupId;
	}

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
