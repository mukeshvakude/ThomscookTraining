package com.bean;

import java.sql.Date;

public class Post {

	private int post_id;
	private String postTitle,postDescription,postImage;
	private int cat_id;
	private int user_id;
	private Date postedDate; 
	
	public Post() {
		super();
	}
	


	public Post(int post_id, String postTitle, String postDescription, String postImage, int cat_id, int user_id) {
		super();
		this.post_id = post_id;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postImage = postImage;
		this.cat_id = cat_id;
		this.user_id = user_id;
	}



	public Post(String postTitle, String postDescription, String postImage, int cat_id, int user_id) {
		super();
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postImage = postImage;
		this.cat_id = cat_id;
		this.user_id = user_id;
	}



	public String getPostImage() {
		return postImage;
	}



	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}



	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", postTitle=" + postTitle + ", postDescription=" + postDescription + ", user_id=" + user_id + "]";
	}

	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date date) {
		this.postedDate = date;
		
	}




	
	
}
