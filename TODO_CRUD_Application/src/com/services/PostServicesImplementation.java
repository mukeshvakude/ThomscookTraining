package com.services;

import java.util.List;


import com.bean.Post;
import com.dao.PostDao;

public class PostServicesImplementation implements PostServices{
	PostDao postdao;

	public PostServicesImplementation(PostDao postdao) {
		super();
		this.postdao = postdao;
	}

	@Override
	public boolean addPost(Post post) {
		return postdao.addPost(post);
	}

	@Override
	public List<Post> getAllPost() {
		return postdao.getAllPost();
	}

	@Override
	public List<Post> getPostByCategoryid(int cat) {
	
		return postdao.getPostByCategoryid(cat);
	}

	
	
}
