package org.anil.collabrationbackend.dao;

import java.util.List;

import org.anil.collabrationbackend.model.User;

public interface UserDAO 
{
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserByUserName(String username);
	public List<User> listUsers();


}
