package org.anil.collabrationbackend.controller;

import java.util.List;

import org.anil.collabrationbackend.dao.JobsDAO;
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
public class JobsRestController {

	@Autowired
	JobsDAO jobsdao;
	
	 @RequestMapping(value = "/jobs/", method = RequestMethod.GET)
		public ResponseEntity<List<Jobs>>  listblogs()
		{
			List<Jobs> jobs = jobsdao.listJobs();
			if(jobs.isEmpty())
			{
				return new ResponseEntity<List<Jobs>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.OK);
		}
	 
	 /* creating user*/
	 @RequestMapping(value = "/jobs", method = RequestMethod.POST)
		public ResponseEntity<Void>  addBlogData(@RequestBody Jobs jobs, UriComponentsBuilder ucBuilder)
		{
			
					
			jobsdao.addJobs(jobs);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/jobs/{jobId}").buildAndExpand(jobs.getJobId()).toUri());
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}
	 
	 //updating the user
	 
	 @RequestMapping(value="/jobs/{jobId}",method=RequestMethod.PUT)
	 public ResponseEntity<Jobs> UpdateJobs (@RequestBody Jobs job, @PathVariable("jobId") int jId)
	 {
		
		
		 Jobs jobUpdate = jobsdao.getJobById(jId);
		 jobUpdate.setAddressOfTheCompany(job.getAddressOfTheCompany());
		 jobUpdate.setCompany(job.getCompany());
		 jobUpdate.setCtc(job.getCtc());
		 jobUpdate.setDateOfInterview(job.getDateOfInterview());
		 jobUpdate.setEligibilityCriteria(job.getEligibilityCriteria());
		 jobUpdate.setRoles(job.getRoles());
		 jobUpdate.setSkillRequired(job.getSkillRequired());
		 jobUpdate.setUrlOfTheCompany(job.getUrlOfTheCompany());
		 jobsdao.addJobs(jobUpdate);
			return new ResponseEntity<Jobs>(HttpStatus.OK);
		 
	 }
	 
	//delete an existing user
		@RequestMapping(value="/jobs/delete/{jobId}",method=RequestMethod.DELETE)
		public void deleteJobs(@PathVariable("jobId") int jId)
		{
			jobsdao.deleteJob(jId);
		}
		
}
