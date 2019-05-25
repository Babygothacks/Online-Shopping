package net.Ganesh.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.Ganesh.shoppingbackend.dao.CategoryDAO;
import net.Ganesh.shoppingbackend.dto.Category;

@Repository("categories")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Category> list() {
		//Hibernate query language - Category,active in below is Entity not from database
		String getActiveCategory = "FROM Category WHERE active = :_param_active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(getActiveCategory);
		
		query.setParameter("_param_active", true);
		
		return query.getResultList();
	}
/*
 * (non-Javadoc)
 * @see net.Ganesh.shoppingbackend.dao.CategoryDAO#getCategory(int)
 * 
 * getting single category based on id
 */
	@Override
	public Category getCategory(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	
	public boolean addCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
