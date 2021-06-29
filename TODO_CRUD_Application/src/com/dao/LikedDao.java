package com.dao;

public interface LikedDao {

	boolean likepost(int user_id,int post_id);
	boolean dislikepost(int user_id,int post_id);
	int getlikeCount(int post_id);
	int getdislikeCount(int post_id);
}
