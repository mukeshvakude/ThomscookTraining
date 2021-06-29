package com.services;

import java.util.List;

import com.bean.Categories;
import com.dao.CategoriesDao;

public class CategoriesServiceImlementation implements CategoriesServices {

	CategoriesDao catDao;
	
	public CategoriesServiceImlementation(CategoriesDao catDao) {
		super();
		this.catDao = catDao;
	}

	@Override
	public boolean addCategorie(Categories categories) {
		// TODO Auto-generated method stub
		return catDao.addCategorie(categories);
	}

	@Override
	public List<Categories> getAllCategories() {
		// TODO Auto-generated method stub
		return catDao.getAllCategories();
	}

}
