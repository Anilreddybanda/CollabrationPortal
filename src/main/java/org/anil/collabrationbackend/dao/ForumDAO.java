package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.Forum;
import org.anil.collabrationbackend.model.Jobs;

public interface ForumDAO {

	public void addForum(Forum f);
	public void updateForum(int fId);
	public void deleteForum(int fId);
	public Forum getForumById(int fId);
	public List<Forum> listForum();
}
