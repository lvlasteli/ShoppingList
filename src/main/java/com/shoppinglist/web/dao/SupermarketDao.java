package com.shoppinglist.web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppinglist.web.model.Supermarket;

@Repository
public interface SupermarketDao extends CrudRepository<Supermarket, Long>{

}