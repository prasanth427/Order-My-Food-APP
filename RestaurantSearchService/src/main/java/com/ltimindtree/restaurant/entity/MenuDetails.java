package com.ltimindtree.restaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Menu_Details")
public class MenuDetails {

	@Id
	private long menuId;

	@Column(nullable = false)
	private String menuName;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(nullable = false)
	private double price;

	public MenuDetails() {

	}

	public MenuDetails(long menuId, String menuName, String description, double price) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuDetails [menuId=" + menuId + ", menuName=" + menuName + ", description=" + description + ", price="
				+ price + "]";
	}

}
