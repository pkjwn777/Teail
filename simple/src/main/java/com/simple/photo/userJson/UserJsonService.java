package com.simple.photo.userJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.simple.photo.DataNotFoundException;
import com.simple.photo.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserJsonService {

	private final UserJsonRepository userjsonRepository;
	
	public Integer CountLib(JSONObject jsonObject) {
		JSONArray jsonArray = (JSONArray) jsonObject.get("fileNum");
		
		ArrayList<Integer> numlist = new ArrayList<>();
		for (Object arr : jsonArray) {
			JSONObject jobject = (JSONObject) arr;
			numlist.add((Integer)jobject.get("fileNum"));
		}
		Integer numcount = numlist.size();
		return numcount;
	}
	
public void JavaToJson(UserJsonInputDto jsonInputDto) {
	Optional<UserJson> userjson = userjsonRepository.findById(jsonInputDto.getUserNum());
	Integer numcount = 0;
	if (userjson.isPresent()) {
        numcount = CountLib(userjson.get().getJsonFile());
    } else {
        throw new DataNotFoundException("해당유저의 정보가 없습니다");
    }	
	Integer filenum = 0;
	switch(numcount) {
	case 0:
		filenum = 1;
		break;
	case 1 :
		filenum = 2;
		break;
	case 2:
		filenum = 3;
		break;
	case 3:
		
		break;
	}
	JSONObject Jsonfile = jsonInputDto.getUserLib();
	
	
	}
	
//	private UserJson create(User user, String JsonFile, String JsonName) {
//		UserJson userjson = new UserJson();
//		userjson.setUser(user);
//		userjson.setJsonFile(JsonFile);
//		userjson.setJsonName(JsonName);
//		this.userjsonRepository.save(userjson);
//		return userjson;
//	}
//	
//	public List<UserJson> getList(){
//		return this.userjsonRepository.findAll();
//	}
//	
//	public UserJson getUserJson(Long JsonID) {
//		Optional<UserJson> userjson = this.userjsonRepository.findById(JsonID);
//		if (userjson.isPresent())
//			return userjson.get();
//		else
//			throw new DataNotFoundException("해당 라이브러리가 없습니다.");
//	}
//	public void modify(UserJson userjson, String jsonfile, String jsonname) {
//		userjson.setJsonFile(jsonfile);
//		userjson.setJsonName(jsonname);
//		this.userjsonRepository.save(userjson);
//	}
//	public void delete(UserJson userjson) {
//		this.userjsonRepository.delete(userjson);
//	}
}
