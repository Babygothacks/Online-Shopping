package net.Ganesh.shoppingbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.Ganesh.shoppingbackend.dao.IProductDAO;
import net.Ganesh.shoppingbackend.dto.Product;

@Repository("ProductsRepo")
@Transactional
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProductBasedOnCategory(int categoryID) {
		String getActiveProductByCategory = "FROM Product Where categoryId = :_param_catID and active = :_param_active";

		try {
			return sessionFactory.getCurrentSession().createQuery(getActiveProductByCategory, Product.class)
					.setParameter("_param_catID", Integer.valueOf(categoryID)).setParameter("_param_active", true)
					.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> listLatestActiveProduct(int count) {
		String getlistLatestActiveProduct = "FROM Product Where active = :_param_active ORDER BY id desc";

		try {
			return sessionFactory.getCurrentSession().createQuery(getlistLatestActiveProduct, Product.class)
					.setParameter("_param_active", true).setFirstResult(0).setMaxResults(count).getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> listActiveProduct() {
		try {
			String getProduct = "FROM Product WHERE active = :_param_active";
			return sessionFactory.getCurrentSession().createQuery(getProduct, Product.class)
					.setParameter("_param_active", true).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
