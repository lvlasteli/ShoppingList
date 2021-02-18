package com.shoppinglist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppinglist.web.dao.CategoryDao;
import com.shoppinglist.web.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	public void saveAll(List<Category> categories) {
		categoryDao.saveAll(categories);
	}
}
