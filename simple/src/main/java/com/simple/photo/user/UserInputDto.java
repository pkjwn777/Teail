package com.simple.photo.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDto {
	private String UserId;
	private String UserPassword;
	private String UserPasswordConfirm;
	private String UserQuestion;
	private String UserAnswer;
	private String UserNewPassword;
	private String UserNewPasswodConfirm;
	private Long UserNum;
	private Boolean Yn;
}
