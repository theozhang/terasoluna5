package com.dhc.uim.domain.repository.user;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.dhc.uim.domain.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static final Map<String, User> User_MAP = 
			new ConcurrentHashMap<String,User>();

	static {
		User user1 = new User();
		user1.setUserId("100001");
		user1.setUserName("zhangsan");
		user1.setUserStatus("1");
		User user2 = new User();
		user2.setUserId("100002");
		user2.setUserName("Lisi");
		user2.setUserStatus("0");
		User_MAP.put(user1.getUserId(), user1);
		User_MAP.put(user2.getUserId(), user2);
		}
	
	@Override
	public Optional<User> findById(String UserId) {
		return Optional.ofNullable(User_MAP.get(UserId));
	}

	@Override
	public Collection<User> findAll() {
		return User_MAP.values();
	}

	@Override
	public void create(User User) {
		User_MAP.put(User.getUserId(), User);
	}

	@Override
	public boolean updateById(User User) {
		User_MAP.put(User.getUserId(), User);
		return true;
	}

	@Override
	public void deleteById(User User) {
		User_MAP.remove(User.getUserId());
	}
	
	@Override
	public long countByFinished(boolean finished) {
		long count = 0;
//		for (User User : User_MAP.values()) {
//			if (finished == User.isFinished()) {
//				count++;
//			}
//		}
		return count;
	}
}
