package com.services;

import com.dao.LikedDao;


public class LikedServicesImplementation implements LikedServices {

	LikedDao likedDao;

	public LikedServicesImplementation(LikedDao likedDao) {
		this.likedDao = likedDao;
	}

	@Override
	public boolean likepost(int user_id, int post_id) {
		
		return likedDao.likepost(user_id, post_id);
	}

	@Override
	public boolean dislikepost(int user_id, int post_id) {
		// TODO Auto-generated method stub
		return likedDao.dislikepost(user_id, post_id);
	}

	@Override
	public int getlikeCount(int post_id) {
		// TODO Auto-generated method stub
		return likedDao.getlikeCount(post_id);
	}

	@Override
	public int getdislikeCount(int post_id) {
		// TODO Auto-generated method stub
		return likedDao.getdislikeCount(post_id);
	}
}
