package com.simple.photo.userJson;

import jakarta.validation.constraints.NotEmpty;

public class UserJsonForm {

	@NotEmpty(message = "라이브러리 이름은 필수로 입력해주셔야합니다.")
	private String json_name;
}
