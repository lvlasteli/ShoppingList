package com.shoppinglist.web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppinglist.web.model.ApplicationProperty;

@Repository
public interface ApplicationPropertyDao extends CrudRepository<ApplicationProperty, Long>{

}
