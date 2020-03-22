package com.dhc.uim.domain.service.user;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.dhc.uim.domain.model.User;
import com.dhc.uim.domain.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final long MAX_UNFINISHED_COUNT = 5;
	
	@Inject// (3)
	UserRepository userRepository;
	
	private User findOne(String userId) {
		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
		// (5)
		ResultMessages messages = ResultMessages.error();
		messages.add(ResultMessage
		.fromText("[E404] The requested user is not found. (id="
		+ userId + ")"));
		// (6)
		throw new ResourceNotFoundException(messages);
		}
		return user;
		}
	
	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {

		String userId = UUID.randomUUID().toString();
		Date createdAt = new Date();
		user.setUserId(userId);
//		user.setCreatedAt(createdAt);
//		user.setFinished(false);
		userRepository.create(user);
		return user;
	}

	@Override
	public User finish(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String userId) {
		User user = findOne(userId);
		userRepository.deleteById(user);
	}

}
