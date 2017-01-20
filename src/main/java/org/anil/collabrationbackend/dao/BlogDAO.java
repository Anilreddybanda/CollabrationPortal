package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Blog;

public interface BlogDAO {
	public void addBlog(Blog b);
	public void updateBlog(int bId);
	public void deleteBlog(int blogid);
	public Blog getBlogById(String blogid);
	public List<Blog> listBlog();

}
