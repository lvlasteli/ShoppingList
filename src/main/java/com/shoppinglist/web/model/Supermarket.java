package com.shoppinglist.web.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Supermarkets")
public class Supermarket {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Lob
	@Column(name="image")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] image;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "items_supermarkets", joinColumns = @JoinColumn(name = "supermarkets_id"),
				inverseJoinColumns = @JoinColumn(name = "items_id"))
	private Set<Supermarket> supermarkets;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Supermarket> getSupermarkets() {
		return supermarkets;
	}

	public void setSupermarkets(Set<Supermarket> supermarkets) {
		this.supermarkets = supermarkets;
	}
	
	public Supermarket() {
		
	}
	
	public Supermarket(String name, byte[] image) {
		this.name = name;
		this.image = image;
	}
}
