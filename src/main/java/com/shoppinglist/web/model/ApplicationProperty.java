package com.shoppinglist.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_properties")
public class ApplicationProperty {

	@Id
	private long id;
	
	@Column(nullable = false)
	private Long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	public ApplicationProperty() {
		
	}
	
	public ApplicationProperty(long id, Long version) {
		this.id = id;
		this.version = version;
	}
}
