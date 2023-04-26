package com.ltimindtree.restaurant.service;

import java.util.List;

import com.ltimindtree.restaurant.entity.MenuDetails;

public interface MenuDetailsService {

	public MenuDetails findByMenuId(long menuId);

	public List<MenuDetails> findByMenuName(String menuName);

	public MenuDetails saveMenuDetails(MenuDetails menuDetails);
}
