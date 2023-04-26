package com.ltimindtree.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.restaurant.entity.MenuDetails;
import com.ltimindtree.restaurant.repository.MenuDetailsRepository;
import com.ltimindtree.restaurant.service.MenuDetailsService;

@Service
public class MenuDetailsImpl implements MenuDetailsService {

	@Autowired
	private MenuDetailsRepository menuDetailsRepo;

	@Override
	public MenuDetails findByMenuId(long menuId) {

		return menuDetailsRepo.findById(menuId).get();
	}

	@Override
	public List<MenuDetails> findByMenuName(String menuName) {

		return menuDetailsRepo.findByMenuName(menuName);
	}

	@Override
	public MenuDetails saveMenuDetails(MenuDetails menuDetails) {

		return menuDetailsRepo.save(menuDetails);
	}

}
