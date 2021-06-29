package com.services;

import java.util.List;
import com.bean.Post;


public interface PostServices {


	boolean addPost(Post post);
	List<Post> getAllPost();
	List<Post> getPostByCategoryid(int catid);
	
}
