package com.dao;

import java.util.List;

import com.bean.Categories;

public interface CategoriesDao {
	
		boolean addCategorie(Categories categories);
		List<Categories> getAllCategories();

	

}
