package com.simple.photo.user;

import lombok.Getter;

@Getter
public class UserRequestDto {
	Long UserNum;
	String UserId;
	String UserPassword;
	String UserQuestion;
	String UserAnswer;
}
