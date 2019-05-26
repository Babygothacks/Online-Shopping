package net.Ganesh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.Ganesh.shoppingbackend.dao.IProductDAO;
import net.Ganesh.shoppingbackend.daoimpl.ProductDAOImpl;
import net.Ganesh.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static IProductDAO iProductDAO;
	
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.Ganesh.shoppingbackend");
		context.refresh();

		iProductDAO  = (IProductDAO) context.getBean("ProductsRepo");
	}
	
	@Test
	public void ProductTestcases()
	{
		//Add pRoduct
		/*
		 * product = new Product();
		 * 
		 * product.setName("Honor 6"); product.setBrand("Huawei");
		 * product.setDescription("This is old phone in market");
		 * product.setUnitPrice(20000.00); product.setQuantity(5);
		 * product.setCategoryId(3); product.setSupplierId(2);
		 * 
		 * 
		 * assertEquals("sucess", true, iProductDAO.add(product));
		 */
		
		//Update product  & get product

		/*
		 * product = iProductDAO.get(6); product.setName("Honor 6 plus");
		 * assertEquals("success", true, iProductDAO.update(product));
		 * 
		 */
		//Delete a product
		/* assertEquals("success", true, iProductDAO.delete(product));
		 */
		
		//list of products
		//assertEquals("success", 5, iProductDAO.list().size());
		
		//listActiveProductBasedOnCategory
		//assertEquals("success", 3, iProductDAO.listActiveProductBasedOnCategory(3).size());
		
		//listLatestActiveProduct
		//assertEquals("success", 2, iProductDAO.listLatestActiveProduct(2).size());
	 

	}
}
