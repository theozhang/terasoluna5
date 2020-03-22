package com.dhc.uim.domain.repository.user;

import java.util.Collection;
import java.util.Optional;

import com.dhc.uim.domain.model.User;

public interface UserRepository {
	Optional<User> findById(String userId);
	Collection<User> findAll();
	void create(User user);
	boolean updateById(User user);
	void deleteById(User user);
	long countByFinished(boolean finished);
}
