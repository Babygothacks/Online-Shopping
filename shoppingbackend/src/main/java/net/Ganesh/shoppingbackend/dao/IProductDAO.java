package net.Ganesh.shoppingbackend.dao;

import java.util.List;

import net.Ganesh.shoppingbackend.dto.Product;

public interface IProductDAO {
 
	
	//Basic crud operations
	Product get(int id);
	List<Product> list();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//List of active Products
	List<Product> listActiveProduct();
	//List of active product based on category
	List<Product> listActiveProductBasedOnCategory(int categoryID);
	//Latest Few active products
	List<Product> listLatestActiveProduct(int count);
	
}
