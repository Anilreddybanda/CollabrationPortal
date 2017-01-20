package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Blog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("blogd")
@Transactional
@EnableTransactionManagement
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBlog(Blog b) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(b);
		
	}

	
	public void updateBlog(int bId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bId);
		
	}

	
	public void deleteBlog(int blogid) {
		Session session = sessionFactory.getCurrentSession();
		Blog blog =(Blog)session.get(Blog.class, new Integer(blogid));
		session.delete(blog);
	}


	
	public List<Blog> listBlog() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Blog> list=session.createCriteria(Blog.class).list();
		
		
		return list;
	}


	
	public Blog getBlogById(String blogid) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
