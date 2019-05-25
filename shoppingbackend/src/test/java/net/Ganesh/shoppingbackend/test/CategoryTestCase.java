package net.Ganesh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.Ganesh.shoppingbackend.dao.CategoryDAO;
import net.Ganesh.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.Ganesh.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categories");
	}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some television description");
		category.setImageURL("CAT_1.png");
		
		assertEquals("successfully added", true, categoryDAO.addCategory(category));
	}

}
