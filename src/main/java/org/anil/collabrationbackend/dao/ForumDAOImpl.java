package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Forum;
import org.anil.collabrationbackend.model.Jobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("forum")
@Transactional
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addForum(Forum f) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(f);
	}

	
	public void updateForum(int fId) 
	{
		Session session = sessionFactory.getCurrentSession();
	    session.update(fId);
	}

	
	public void deleteForum(int fId) {
		Session session = sessionFactory.getCurrentSession();
		Forum forum =(Forum)session.get(Forum.class, new Integer(fId));
		session.delete(forum);
	}

	
	public Forum getForumById(int fId) {
		Session session = sessionFactory.getCurrentSession();
		Forum forum =(Forum)session.get(Forum.class, new Integer(fId));
		 return forum;
	}

	
	public List<Forum> listForum() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Forum> list=session.createCriteria(Forum.class).list();
		return list;	}

}
