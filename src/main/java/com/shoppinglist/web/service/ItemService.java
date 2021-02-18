package com.shoppinglist.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppinglist.web.dao.ItemDao;
import com.shoppinglist.web.model.Item;

@Service
public class ItemService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItems() {
		return itemDao.findAll();
	}

	public List<Item> getUsersItems(long userId, String option) {
		if(option.equals("ASC")) return itemDao.findAllByUserIdOrderByNameAsc(userId);
		else return itemDao.findAllByUserIdOrderByNameDesc(userId);
	}
	
	public List<Item> getCategoryItems(long categoryId, String option) {
		if(option.equals("ASC")) return itemDao.findAllByCategoryIdOrderByNameAsc(categoryId);
		else return itemDao.findAllByCategoryIdOrderByNameDesc(categoryId);
	}
	
	public List<Item> getSupermarketItems(long supermarketId, String option) {
		if(option.equals("ASC")) return itemDao.findAllBySupermarketsIdOrderByNameAsc(supermarketId);
		else return itemDao.findAllBySupermarketsIdOrderByNameDesc(supermarketId);
	}

	public void addItem(Item item) {
		itemDao.save(item);
		
	}

	public void modifyItem(Item item) {
		itemDao.save(item);
	}

	public void deleteItem(long itemId) {
		itemDao.deleteById(itemId);
	}

}
