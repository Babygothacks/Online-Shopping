package net.Ganesh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.Ganesh.shoppingbackend.dao.CategoryDAO;
/*import net.Ganesh.shoppingbackend.daoimpl.CategoryDAOImpl;*/
import net.Ganesh.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categories;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categoryList",categories.list());
		mv.addObject("HomeClick", true);
		return mv;
	}
	@RequestMapping(value ="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("AboutClick", true);
		return mv;
	}
	@RequestMapping(value ="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("ContactClick", true);
		return mv;
	}
//	@RequestMapping(value = "/test")
//	public ModelAndView test(@RequestParam(value = "greet", required = false) String greeting) {
//		
//		if(greeting == null)
//			greeting="Hello there";
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}

	@RequestMapping(value = "/test/{greet}")
	public ModelAndView test(@PathVariable("greet") String greeting) {

		if (greeting == null)
			greeting = "Hello there";

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	/*
	 * Methods to load all the products based on category
	 */
	@RequestMapping(value = { "/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
		mv.addObject("categoryList",categories.list());
		mv.addObject("AllProductsClick", true);
		return mv;
	}
	@RequestMapping(value = { "/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category _category = null;
		_category = categories.getCategory(id);
		
		mv.addObject("title", _category.getName());
		mv.addObject("categoryList",categories.list());
		mv.addObject("category",_category);
		mv.addObject("ProductsCategoryClick", true);
		return mv;
	}

}
