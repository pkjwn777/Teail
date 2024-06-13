package com.simple.photo.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long UserNum;
	
	@Column(unique = true, length = 50)
private String UserId;

	@Column(length = 50)
private String UserPassword;

	  @Column(columnDefinition = "TEXT")
private String UserQuestion;
	
	  @Column(columnDefinition = "TEXT")
private String UserAnswer;	
	  
public User(UserInputDto userInputDto) {
	  this.UserId = userInputDto.getUserId();
	  this.UserPassword = userInputDto.getUserPassword();
	  this.UserQuestion = userInputDto.getUserQuestion();
	  this.UserAnswer = userInputDto.getUserAnswer(); 
	
	  }

public void UserUpdate(UserRequestDto userRequestDto) {
	  this.UserId = userRequestDto.getUserId();
	  this.UserPassword = userRequestDto.getUserPassword();
	  this.UserQuestion = userRequestDto.getUserQuestion();
	  this.UserAnswer = userRequestDto.getUserAnswer();
}
public String getID() {
	return UserId;
}
public String setID(String id) {
	return UserId;
}
}
