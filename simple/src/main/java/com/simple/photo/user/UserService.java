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
	
	private User create(String UserId, String UserPassword, String UserQuestion, String UserAnswer) {
		User user = new User();
		user.setUserId(UserId);;
		user.setUserPassword(UserPassword);;
		user.setUserQuestion(UserQuestion);;
		user.setUserAnswer(UserAnswer);;
		this.userRepository.save(user);
		return user;
	}
	
	public List<User> getList(){
		return this.userRepository.findAll();
	}
	
	public User getUser(Long UserNum) {
		Optional<User> user = this.userRepository.findById(UserNum);
		if (user.isPresent())
			return user.get();
		else
			throw new DataNotFoundException("해당 아이디가 없습니다.");
	}
	
	public void modify(User user, String UserPassword, String UserQuestion, String UserAnswer) {
		user.setUserPassword(UserPassword);;
		user.setUserQuestion(UserQuestion);;
		user.setUserAnswer(UserAnswer);;
		this.userRepository.save(user);
	}
	
	public void delete(User user) {
		this.userRepository.delete(user);
		
	}
}
