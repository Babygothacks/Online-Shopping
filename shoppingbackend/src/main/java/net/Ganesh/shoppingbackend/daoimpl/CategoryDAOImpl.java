package net.Ganesh.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.Ganesh.shoppingbackend.dao.CategoryDAO;
import net.Ganesh.shoppingbackend.dto.Category;

@Repository("categories")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// First category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some television description");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some Mobile description");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some Laptop description");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		
		for(Category category : categories)
		{
			if(category.getId()== id) return category;
		}		
		
		return null;
	}

}
