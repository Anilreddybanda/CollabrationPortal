package org.anil.collabrationbackend.controller;

import java.util.List;

import org.anil.collabrationbackend.dao.ForumDAO;
import org.anil.collabrationbackend.dao.JobsDAO;
import org.anil.collabrationbackend.model.Forum;
import org.anil.collabrationbackend.model.Jobs;
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
public class ForumRestController {
	@Autowired
	ForumDAO forumdao;
	
	 @RequestMapping(value = "/forum/", method = RequestMethod.GET)
		public ResponseEntity<List<Forum>>  listForum()
		{
			List<Forum> forum = forumdao.listForum();
			if(forum.isEmpty())
			{
				return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Forum>>(forum, HttpStatus.OK);
		}
	 
	 /* creating user*/
	 @RequestMapping(value = "/forum", method = RequestMethod.POST)
		public ResponseEntity<Void>  addBlogData(@RequestBody Forum forum, UriComponentsBuilder ucBuilder)
		{
			
					
			forumdao.addForum(forum);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/forum/{fId}").buildAndExpand(forum.getfId()).toUri());
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}
	 
	 //updating the user
	 
	 @RequestMapping(value="/forum/{fId}",method=RequestMethod.PUT)
	 public ResponseEntity<Jobs> UpdateJobs (@RequestBody Forum forum, @PathVariable("fId") int fId)
	 {
		
		
		 Forum forumUpdate = forumdao.getForumById(fId);
		 forumUpdate.setForumTitle(forum.getForumTitle());
		 forumUpdate.setForumDescription(forum.getForumTitle());
	
		 forumdao.addForum(forumUpdate);
			return new ResponseEntity<Jobs>(HttpStatus.OK);
		
	 }
	 
	//delete an existing user
		@RequestMapping(value="/forum/delete/{fId}",method=RequestMethod.DELETE)
		public void deleteJobs(@PathVariable("fId") int foId)
		{
			forumdao.deleteForum(foId);
		}
		
}
