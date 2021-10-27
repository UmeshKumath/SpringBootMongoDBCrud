package com.example.dal;

import java.util.List;

import com.example.model.User;

public interface UsersDAL {
	
	List<User> getAllUsers();
	
	User getUserbyId(String userId);
	
	User addNewUser(User user);
	
	Object getAllUserSetting(String userId);
	
	String getUserSetting(String userId, String key);
	
	String addUserSetting(String userId, String key, String value);

}
