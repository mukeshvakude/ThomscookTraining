package com.bean;

public class Liked {
	private int like_id,user_id,post_id,liked,disliked;

	public Liked(int like_id, int user_id, int post_id) {
		super();
		this.like_id = like_id;
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public Liked(int user_id, int post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public Liked() {
		super();
	}

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public int getDisliked() {
		return disliked;
	}

	public void setDisliked(int disliked) {
		this.disliked = disliked;
	}
	
}
