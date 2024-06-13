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
	
	private Long JsonID;
	private Long UserNum;
	private JSONObject JsonFile;
	private String JsonName;
	
	private int FileNum;
	private String UserId;
	private String UserPassword;
	private String UserPasswordConfirm;
	private JSONObject UserLib;
	private int NumFileNum;
}
