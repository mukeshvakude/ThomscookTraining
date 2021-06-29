package com.services;

import java.util.List;

import com.bean.Categories;


public interface CategoriesServices {
	boolean addCategorie(Categories categories);
	List<Categories> getAllCategories();

}
