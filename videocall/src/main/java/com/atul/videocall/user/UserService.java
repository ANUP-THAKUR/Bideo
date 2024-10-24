package com.atul.videocall.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final List<User> UsersList = new ArrayList<>();
	
	public void register(User user) {
		user.setStatus("online");
		UsersList.add(user);
	}
	
	public User login(User user) {
		var userIndex = IntStream.range(0, UsersList.size())
				.filter(i -> UsersList.get(i).getEmail().equals(user.getEmail()))
				.findAny()
				.orElseThrow(() -> new RuntimeException("user not found"));
		var cUser = UsersList.get(userIndex);
		if(!cUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("incorrect  password");
		}
		cUser.setStatus("online");
		return cUser;
	}
	
	public void logout(String email) {
		var userIndex = IntStream.range(0, UsersList.size())
				.filter(i -> UsersList.get(i).getEmail().equals(email))
				.findAny()
				.orElseThrow(() -> new RuntimeException("user not found"));
		UsersList.get(userIndex).setStatus("offline");
	}
	
	public List<User> findAll(){
		return UsersList;
	}
}
