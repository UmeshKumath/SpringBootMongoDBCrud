package com.example.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.model.User;

public class UserDALImpl implements UsersDAL {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserbyId(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public Object getAllUserSetting(String userId) {
		Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user!=null?user.getUserSettings():"User not found";
	}

	@Override
	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings().get(key) : "Not found.";
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added.";
		} else {
			return "User not found.";
		}
	}
	

}
