package com.simple.photo.userJson;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simple.photo.DataNotFoundException;
import com.simple.photo.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserJsonService {

	private final UserJsonRepository userjsonRepository;
	
	private UserJson create(User user, String JsonFile, String JsonName) {
		UserJson userjson = new UserJson();
		userjson.setUser(user);
		userjson.setJsonFile(JsonFile);
		userjson.setJsonName(JsonName);
		this.userjsonRepository.save(userjson);
		return userjson;
	}
	
	public List<UserJson> getList(){
		return this.userjsonRepository.findAll();
	}
	
	public UserJson getUserJson(Long JsonID) {
		Optional<UserJson> userjson = this.userjsonRepository.findById(JsonID);
		if (userjson.isPresent())
			return userjson.get();
		else
			throw new DataNotFoundException("해당 라이브러리가 없습니다.");
	}
	public void modify(UserJson userjson, String jsonfile, String jsonname) {
		userjson.setJsonFile(jsonfile);
		userjson.setJsonName(jsonname);
		this.userjsonRepository.save(userjson);
	}
	public void delete(UserJson userjson) {
		this.userjsonRepository.delete(userjson);
	}
}
