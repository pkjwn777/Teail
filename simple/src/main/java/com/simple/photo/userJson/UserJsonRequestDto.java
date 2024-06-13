package com.simple.photo.userJson;

import org.json.simple.JSONObject;

import lombok.Getter;

@Getter
public class UserJsonRequestDto {

	private Long JsonID;
	private Long UserNum;
	private JSONObject JsonFile;
	private String JsonName;
}
