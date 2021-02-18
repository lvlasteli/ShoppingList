package com.shoppinglist.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppinglist.web.dao.UserDao;
import com.shoppinglist.web.model.User;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public void createUser(User user) {
		userDao.save(user);
		LOGGER.info("User created " + user.getName() + " with id: " + user.getId());
	}
}
