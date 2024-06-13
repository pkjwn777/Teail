package com.simple.photo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.photo.ResponseDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired UserService userService;
	
	//회원가입
	@PostMapping("/createAccount")
	public ResponseDto<?> createAccount(@RequestBody UserInputDto userInputDto) {
		ResponseDto<?> responseDto = userService.create(userInputDto);
		return responseDto;
	}
	
	//회원탈퇴
@DeleteMapping("/delete/{id}")
public ResponseDto<?> deleteAccount(@RequestBody UserInputDto userInputDto) {
	ResponseDto<?> responseDto = userService.delete(userInputDto);
	return responseDto;
}

////회원수정
@PostMapping("/modify/{id}")
public ResponseDto<?> modifyAccount(@RequestBody UserInputDto userInputDto) {
	ResponseDto<?> responseDto = userService.modify(userInputDto);
	return responseDto;
}
}
