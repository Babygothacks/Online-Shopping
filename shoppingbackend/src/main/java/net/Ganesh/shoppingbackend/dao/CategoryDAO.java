package net.Ganesh.shoppingbackend.dao;

import java.util.List;

import net.Ganesh.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category getCategory(int id);
	
}
