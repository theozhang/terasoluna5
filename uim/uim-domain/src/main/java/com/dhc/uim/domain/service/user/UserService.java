package com.dhc.uim.domain.service.user;

import java.util.Collection;

import com.dhc.uim.domain.model.User;

public interface UserService {
	Collection<User> findAll();
	User create(User user);
	User finish(String userId);
	void delete(String userId);
}
