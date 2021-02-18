package com.shoppinglist.web.db_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import com.shoppinglist.web.dao.ApplicationPropertyDao;
import com.shoppinglist.web.dao.CategoryDao;
import com.shoppinglist.web.dao.SupermarketDao;
import com.shoppinglist.web.model.ApplicationProperty;
import com.shoppinglist.web.model.Category;
import com.shoppinglist.web.model.Supermarket;

import ch.qos.logback.core.util.Loader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class DatabaseInitialise {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInitialise.class);
	
	@Autowired
	private ApplicationPropertyDao applicationPropertyDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SupermarketDao supermarketDao;
	
	private ClassLoader classLoader;
	
	@PostConstruct
	public void InitialiseDB() {
		classLoader = this.getClass().getClassLoader();
		LOGGER.info("------Initialising database------");
		if(applicationPropertyDao.count() == 0) {
			try {
				insertCategories();
				insertSupermarkets();
				applicationPropertyDao.save(new ApplicationProperty(1L, 1L));
			} catch (IOException e) {
				LOGGER.error("Initialise Failed: " + e.getLocalizedMessage());
			}
		}
	}
	
	private void insertCategories() throws IOException {
		List<Category> categories = Arrays.asList(
				new Category("Voce/Povrce", "Fruit/Vegetables", classLoader.getResourceAsStream("icons/category_fruit.png").readAllBytes()),
				new Category("Zacini", "Spices", classLoader.getResourceAsStream("icons/category_spice.png").readAllBytes()),
				new Category("Mlijecni proizvodi","Dairy product",  classLoader.getResourceAsStream("icons/category_dairy.png").readAllBytes()),
				new Category("Konzerve", "Canned food", classLoader.getResourceAsStream("icons/supermarkets_tommy.png").readAllBytes()),
				new Category("Sok", "Juice", classLoader.getResourceAsStream("icons/category_juice.png").readAllBytes()),
				new Category("Meso", "Meat", classLoader.getResourceAsStream("icons/category_meat.png").readAllBytes()),
				new Category("Namazi", "Spread", classLoader.getResourceAsStream("icons/category_spread.png").readAllBytes()),
				new Category("Grickalice", "Snacks", classLoader.getResourceAsStream("icons/category_snacks.png").readAllBytes()),
				new Category("Sprej", "Spray", classLoader.getResourceAsStream("icons/category_spray.png").readAllBytes()),
				new Category("WC potrepstine", "WC supplies", classLoader.getResourceAsStream("icons/category_wc_supplies.png").readAllBytes()),
				new Category("Pekarski proizvodi", "Bakery products", classLoader.getResourceAsStream("icons/category_bread.png").readAllBytes()),
				new Category("Razno", "Etc", null));
		categoryDao.saveAll(categories);
	}
	
	public void insertSupermarkets() throws IOException {
		List<Supermarket> supermarkets = Arrays.asList(
				new Supermarket("Tommy", classLoader.getResourceAsStream("icons/supermarkets_tommy.png").readAllBytes()),
				new Supermarket("Lidl", classLoader.getResourceAsStream("icons/supermarkets_lidl.png").readAllBytes()),
				new Supermarket("Kaufland", classLoader.getResourceAsStream("icons/supermarkets_kaufland.png").readAllBytes()),
				new Supermarket("Interspar", classLoader.getResourceAsStream("icons/supermarkets_interspar.png").readAllBytes()),
				new Supermarket("Pivac", classLoader.getResourceAsStream("icons/supermarkets_pivac.png").readAllBytes()),
				new Supermarket("Ribola", classLoader.getResourceAsStream("icons/supermarkets_ribola.png").readAllBytes()),
				new Supermarket("Studenac", classLoader.getResourceAsStream("icons/supermarkets_studenac.png").readAllBytes()),
				new Supermarket("Konzum", classLoader.getResourceAsStream("icons/supermarkets_konzum.png").readAllBytes()),
				new Supermarket("Plodine", classLoader.getResourceAsStream("icons/supermarkets_plodine.png").readAllBytes()),
				new Supermarket("", null));
		supermarketDao.saveAll(supermarkets);
	}
	
}
