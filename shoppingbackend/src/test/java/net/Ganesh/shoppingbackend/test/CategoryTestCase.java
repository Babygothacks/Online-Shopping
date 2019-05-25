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
	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("Watch");
	 * category.setDescription("This is some Watch description");
	 * category.setImageURL("CAT_4.png"); category.setActive(false);
	 * 
	 * assertEquals("successfully added", true, categoryDAO.addCategory(category));
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.getCategory(1); assertEquals("successfully fetched",
	 * "Television", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category =
	 * categoryDAO.getCategory(2);
	 * 
	 * category.setName("lappy"); assertEquals("successfully fetched", true,
	 * categoryDAO.updateCategory(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { assertEquals("successfully deleted",
	 * true, categoryDAO.deleteCategory(categoryDAO.getCategory(5)));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategorylist() {
	 * 
	 * assertEquals("successfully fetched list", 3, categoryDAO.list().size()); }
	 */

	@Test
	public void CRUDCategory() {
		// Add
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some laptop description");
		category.setImageURL("CAT_1.png");

		assertEquals("successfully added", true, categoryDAO.addCategory(category));
		category = new Category();

		category.setName("Television");
		category.setDescription("This is some television description");
		category.setImageURL("CAT_2.png");

		assertEquals("successfully added", true, categoryDAO.addCategory(category));
		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is some mobile description");
		category.setImageURL("CAT_3.png");

		assertEquals("successfully added", true, categoryDAO.addCategory(category));
		category = new Category();

		category.setName("Watch");
		category.setDescription("This is some Watch description");
		category.setImageURL("CAT_4.png");

		assertEquals("successfully added", true, categoryDAO.addCategory(category));

		/*
		 * // fetch and update
		 * 
		 * category = categoryDAO.getCategory(2);
		 * 
		 * category.setName("Tv"); assertEquals("successfully fetched", true,
		 * categoryDAO.updateCategory(category));
		 * 
		 * // delete the category assertEquals("successfully deleted", true,
		 * categoryDAO.deleteCategory(category)); // fetching the result
		 * assertEquals("successfully fetched list", 1, categoryDAO.list().size());
		 */
	}

}
