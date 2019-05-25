package net.Ganesh.shoppingbackend.dao;

import java.util.List;

import net.Ganesh.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	boolean addCategory(Category category);
	List<Category> list();
	Category getCategory(int id);
	
}
