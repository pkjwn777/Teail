package com.simple.photo.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDto {
	private String userId;
	private String userPassword;
	private String userPasswordConfirm;
	private String userQuestion;
	private String userAnswer;
	private String userNewPassword;
	private String userNewPasswodConfirm;
	private Long userNum;
	private Boolean yn;
}
