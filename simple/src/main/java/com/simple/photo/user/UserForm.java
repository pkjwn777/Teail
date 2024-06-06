package com.simple.photo.user;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {

	@NotEmpty(message = "ID는 필수로 입력해주셔야합니다.")
	private String UserId;
	
	@NotEmpty(message = "Password는 필수로 입력해주셔야합니다.")
	private String UserPassword;
	
	@NotEmpty(message = "질문은 필수로 선택해주셔야합니다.")
	private String UserQuestion;
	
	@NotEmpty(message = "답변은 필수로 입력해주셔야합니다.")
	private String UserAnswer;
}
