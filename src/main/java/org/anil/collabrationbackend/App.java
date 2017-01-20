package org.anil.collabrationbackend;

import java.util.Date;

import org.anil.collabrationbackend.config.AppcontextConfig;
import org.anil.collabrationbackend.dao.BlogDAO;
import org.anil.collabrationbackend.dao.ForumDAO;
import org.anil.collabrationbackend.dao.JobsDAO;
import org.anil.collabrationbackend.dao.UserDAO;
import org.anil.collabrationbackend.model.Blog;
import org.anil.collabrationbackend.model.Jobs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{ public static void main( String[] args )
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppcontextConfig.class);
	UserDAO userDAO = (UserDAO) context.getBean("userdao");
	BlogDAO blogDAO=(BlogDAO) context.getBean("blogd");
	JobsDAO jobsDAO=(JobsDAO) context.getBean("jobs");
	ForumDAO forumDAO=(ForumDAO) context.getBean("forum");
	
//	Blog blog = new Blog();
//	blog.setbDiscription("This Blog is a sample blog");
//	blog.setbName("Anil");
//	blog.setCategory("IT");
//	blog.setPostedBY("Anil");
//	blog.setTime(new Date());
//	blogDAO.addBlog(blog);
	Jobs job =new Jobs();
	
	job.setAddressOfTheCompany("madhapu,Hyderabad");
	job.setCompany("Anil Infotech");
	job.setCtc("2.4LPA");
	job.setDateOfInterview("21/01/2017");
	job.setEligibilityCriteria("B-tech");
	job.setRoles("Software developer");
	job.setSkillRequired("Java,AngularJS");
	job.setUrlOfTheCompany("www.anilinfotech.com");
	jobsDAO.addJobs(job);
	
}
   
}
