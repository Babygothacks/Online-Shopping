package net.Ganesh.shoppingbackend.dao;

import java.util.List;

import net.Ganesh.shoppingbackend.dto.Category;

public interface CategoryDAO {

	Category getCategory(int id);
	List<Category> list();	
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
}
