package net.Ganesh.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.Ganesh.shoppingbackend.dao.IProductDAO;
import net.Ganesh.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private IProductDAO iproductDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> allProducts() {
		return iproductDAO.list();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> categoryBasedProduct(@PathVariable int id) {
		return iproductDAO.listActiveProductBasedOnCategory(id);
	}

}
