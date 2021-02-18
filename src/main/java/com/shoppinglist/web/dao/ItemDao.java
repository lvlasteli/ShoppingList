package com.shoppinglist.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppinglist.web.model.Item;

@Repository
public interface ItemDao extends CrudRepository<Item, Long> {
	
	List<Item> findAll();

	List<Item> findAllByUserIdOrderByNameAsc(long userId);
	
	List<Item> findAllByUserIdOrderByNameDesc(long userId);

	List<Item> findAllByCategoryIdOrderByNameAsc(long categoryId);

	List<Item> findAllByCategoryIdOrderByNameDesc(long categoryId);
	
	List<Item> findAllBySupermarketsIdOrderByNameAsc(long supermarketId);
	
	List<Item> findAllBySupermarketsIdOrderByNameDesc(long supermarketId);

	@Transactional
	void deleteById(long id);
}
