package com.simple.photo.userJson;

import org.json.simple.JSONObject;

import lombok.Getter;

@Getter
public class UserJsonRequestDto {

	private Long jsonID;
	private Long userNum;
	private JSONObject jsonFile;
	private String jsonName;
}
