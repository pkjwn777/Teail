package com.simple.photo.user;

import lombok.Getter;

@Getter
public class UserRequestDto {
	Long userNum;
	String userId;
	String userPassword;
	String userQuestion;
	String userAnswer;
}
