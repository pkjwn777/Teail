package com.simple.photo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple.photo.DataNotFoundException;

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
	
	public List<User> getList(){
		return this.userRepository.findAll();
	}
	
	public User getUser(Long user_num) {
		Optional<User> user = this.userRepository.findById(user_num);
		if (user.isPresent())
			return user.get();
		else
			throw new DataNotFoundException("해당 아이디가 없습니다.");
	}
	
	public void modify(User user, String user_password, String user_question, String user_answer) {
		user.setUser_password(user_password);
		user.setUser_question(user_question);
		user.setUser_answer(user_answer);
		this.userRepository.save(user);
	}
	
	public void delete(User user) {
		this.userRepository.delete(user);
		
	}
}
