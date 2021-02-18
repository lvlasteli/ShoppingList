package com.shoppinglist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppinglist.web.model.Item;
import com.shoppinglist.web.service.ItemService;


@RestController
@RequestMapping("/item")
public class ItemsController {
	
	@Autowired
	private ItemService itemsService;
	
	@GetMapping("/all")
	public List<Item> getAllItems() {
		return itemsService.getItems();
	}
	
	@GetMapping("/user/{userId}/{option}")
	public List<Item> getUsersItems(@PathVariable long userId, @PathVariable String option) {
		return itemsService.getUsersItems(userId, option);
	}
	
	@GetMapping("/category/{categoryId}/{option}")
	public void getCategoryItems(@PathVariable long categoryId, @PathVariable String option) {
		itemsService.getUsersItems(categoryId, option);
	}
	
	@GetMapping("/supermarket/{supermarketId}/{option}")
	public void getSupermarketItems(@PathVariable long supermarketId, @PathVariable String option) {
		itemsService.getSupermarketItems(supermarketId, option);
	}
	
	@PostMapping("/add")
	public void addItem(@RequestBody Item item) {
		itemsService.addItem(item);
	}
	
	@PutMapping("/modify")
	public void modifyItem(@RequestBody Item item) {
		itemsService.modifyItem(item);
	}
	
	@DeleteMapping("/delete/{itemId}")
	public void deleteItem(@PathVariable long itemId) {
		itemsService.deleteItem(itemId);
	}
}
