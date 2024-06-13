package com.simple.photo.userJson;

import org.json.simple.JSONObject;

import com.simple.photo.user.UserInputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonInputDto {
	
	private Long jsonID;
	private Long userNum;
	private JSONObject jsonFile;
	private String jsonName;
	
	private int fileNum;
	private String userId;
	private String userPassword;
	private String userPasswordConfirm;
	private JSONObject userLib;
	private int newFileNum;
}
