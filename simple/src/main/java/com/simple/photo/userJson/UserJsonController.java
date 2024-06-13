package com.simple.photo.userJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.photo.ResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user/library")
public class UserJsonController {

	@Autowired UserJsonService userJsonService;
	
	@PostMapping("/createLibrary")
	public ResponseDto<?> createLibrary(UserJsonInputDto userJsonInputDto){
		ResponseDto<?> responseDto = userJsonService.create(userJsonInputDto);
		return responseDto;
	}
}
