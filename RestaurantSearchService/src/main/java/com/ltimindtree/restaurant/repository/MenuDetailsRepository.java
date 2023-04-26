package com.ltimindtree.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.restaurant.entity.MenuDetails;

@Repository
public interface MenuDetailsRepository extends JpaRepository<MenuDetails, Long> {

	public List<MenuDetails> findByMenuName(String menuName);

}