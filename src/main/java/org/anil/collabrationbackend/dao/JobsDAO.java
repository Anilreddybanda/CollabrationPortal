package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Blog;
import org.anil.collabrationbackend.model.Jobs;

public interface JobsDAO {
	public void addJobs(Jobs job);
	public void updateJobs(int jId);
	public void deleteJob(int jId);
	public Jobs getJobById(int jId);
	public List<Jobs> listJobs();
	
}
