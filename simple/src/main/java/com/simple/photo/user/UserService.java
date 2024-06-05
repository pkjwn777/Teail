package com.simple.photo.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	private User create(String user_id, String user_password, String user_question, String user_answer) {
		User user = new User();
		user.setUser_id(user_id);
		user.setUser_password(user_password);
		user.setUser_question(user_question);
		user.setUser_answer(user_answer);
		this.userRepository.save(user);
		return user;
	}
}
