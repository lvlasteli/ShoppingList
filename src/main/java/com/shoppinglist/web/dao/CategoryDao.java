package com.shoppinglist.web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppinglist.web.model.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

}
