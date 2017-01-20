package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Jobs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("jobs")
@Transactional
@EnableTransactionManagement
public class JobsDAOImpl implements JobsDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addJobs(Jobs job) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(job);
	}

	
	public void updateJobs(int jId) {
		Session session = sessionFactory.getCurrentSession();
		session.update(jId);
		
	}

	
	public void deleteJob(int jId) {
		Session session = sessionFactory.getCurrentSession();
		Jobs job =(Jobs)session.get(Jobs.class, new Integer(jId));
		session.delete(job);
	}

	
	public Jobs getJobById(int jId) {
		Session session = sessionFactory.getCurrentSession();
		Jobs job =(Jobs)session.get(Jobs.class, new Integer(jId));
		return job;
		}

	
	public List<Jobs> listJobs() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Jobs> list=session.createCriteria(Jobs.class).list();
		
		
		return list;
	}

}
