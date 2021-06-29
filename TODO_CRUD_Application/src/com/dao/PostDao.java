package com.dao;

import java.util.List;
import com.bean.Post;

public interface PostDao {

	boolean addPost(Post post);
	List<Post> getAllPost();
	List<Post> getPostByCategoryid(int cat);
	
}
