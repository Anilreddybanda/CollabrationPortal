package org.anil.collabrationbackend.controller;


import java.util.List;

import org.anil.collabrationbackend.dao.BlogDAO;
import org.anil.collabrationbackend.model.Blog;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
public class BlogRestController
{

//	@Autowired
//	UserDao userdao;
//	//retrieve all users
//	
//		@RequestMapping(value="/user",method=RequestMethod.GET)
//		public List<UserCollab> getAllUsers()
//		{
//			return userdao.listUsers();
//		}
//		
//		//retrive a specific user
//		
//		@RequestMapping(value="/user/{username}",method=RequestMethod.GET)
//		public UserCollab getUser(@PathVariable("username") String username)
//		{
//			return userdao.getUserByUsername(username);
//		}
//		
	
	
	@Autowired
	BlogDAO blogdao;
	
	 @RequestMapping(value = "/blogs/", method = RequestMethod.GET)
		public ResponseEntity<List<Blog>>  listblogs()
		{
			List<Blog> users = blogdao.listBlog();
			if(users.isEmpty())
			{
				return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Blog>>(users, HttpStatus.OK);
		}
	 
	 /* creating user*/
	 @RequestMapping(value = "/blogs", method = RequestMethod.POST)
		public ResponseEntity<Void>  addBlogData(@RequestBody Blog blog, UriComponentsBuilder ucBuilder)
		{
			System.out.println("user name="+blog.getbName());
					
			blogdao.addBlog(blog);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(blog.getbId()).toUri());
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}
	 
	 //updating the user
	 
	 @RequestMapping(value="/blogs/{bId}",method=RequestMethod.PUT)
	 public ResponseEntity<Blog> UpdateBlog (@RequestBody Blog blog, @PathVariable("bID") String blogid)
	 {
		
		
			Blog userupdate = blogdao.getBlogById(blogid);
			userupdate.setbDiscription(blog.getbDiscription());
			userupdate.setbName(blog.getbName());
			userupdate.setCategory(blog.getCategory());
			userupdate.setPostedBY(blog.getPostedBY());
			userupdate.setTime(blog.getTime());
			blogdao.addBlog(userupdate);
			return new ResponseEntity<Blog>(HttpStatus.OK);
		 
	 }
	 
	//delete an existing user
		@RequestMapping(value="/blogs/delete/{bId}",method=RequestMethod.DELETE)
		public void deleteBlog(@PathVariable("bId") int blogid)
		{
			blogdao.deleteBlog(blogid);
		}
		
	 
}
