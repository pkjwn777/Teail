package com.simple.photo.userJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.simple.photo.DataNotFoundException;
import com.simple.photo.ResponseDto;
import com.simple.photo.user.UserEntity;
import com.simple.photo.user.UserRepository;
import com.simple.photo.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserJsonService {

	@Autowired UserJsonRepository userjsonRepository;
//	@Autowired UserRepository userRepository;
	
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
	
public JSONObject JavaToJson(UserJsonInputDto jsonInputDto) {
	Long usernum = jsonInputDto.getUserNum();
	UserService userService = new UserService();
	Optional<UserJsonEntity> userjson = userjsonRepository.findByuserNum(usernum);
	Integer numcount = 0;
	
	if (userjson.isPresent()) {
        numcount = CountLib(userjson.get().getJsonFile());
    } else {
    	numcount = 0;
//        throw new DataNotFoundException("해당유저의 정보가 없습니다");
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
		filenum = jsonInputDto.getNewFileNum();
		break;
	}
	JSONObject jsonfile = jsonInputDto.getUserLib();
	String userId = "";
	String userPassword = "";
//	Optional<UserEntity> user = userRepository.findById(usernum);
	Optional<UserEntity> user = userService.getUserByNum(usernum);
	if (!user.isEmpty()) {
        userId = user.get().getUserId();
        userPassword = user.get().getUserPassword();
    } else {
        throw new DataNotFoundException("해당유저의 정보가 없습니다1");
    }	
	String jsonName = jsonInputDto.getJsonName();
	
	JSONObject makejson = new JSONObject();
	makejson.put("fileNum", filenum);
	makejson.put("userNum", usernum);
	makejson.put("userId", userId);
	makejson.put("userPassword", userPassword);
	makejson.put("userLib", jsonfile);
	makejson.put("jsonName", jsonName);
	
	return makejson;
	}
	
	public ResponseDto<?> create(UserJsonInputDto userJsonInputDto) {
		Long userNum = userJsonInputDto.getUserNum();
//		try {
		JSONObject jsonFile = JavaToJson(userJsonInputDto);
//		}catch (Exception e) {
//			// TODO: handle exception
//			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.2");
//		}
Optional<UserJsonEntity> userJsoncheck = userjsonRepository.findByuserNum(userNum);
Long jsonId = (long) 0;
if (userJsoncheck.isEmpty()) {
	 jsonId = makeJsonId();
}
else {
	jsonId = userJsoncheck.get().getJsonId();
}
		UserJsonEntity userJson = new UserJsonEntity(userJsonInputDto);
		try {
			userJson.setJsonId(jsonId);
			userJson.setUserNum(userNum);
			userJson.setJsonFile(jsonFile);
			userjsonRepository.save(userJson);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.3");
		}
		return ResponseDto.setSuccess("라이브러리가 저장되었습니다.");
	}
	
	public List<UserJsonEntity> getList(){
		return this.userjsonRepository.findAll();
	}
	
	public Long makeJsonId() {
		Long jsonId = (long)0;
		List<UserJsonEntity> userJson = getList();
		if (!userJson.isEmpty()) {
			jsonId = userJson.get(userJson.size()-1).getJsonId();
		}
		
		jsonId +=1;
		return jsonId;
	}
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
