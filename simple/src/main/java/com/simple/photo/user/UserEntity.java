package com.simple.photo.user;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
//@Primary
@Entity(name = "userinfo")
@Table(name = "userinfo")
public class UserEntity {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userNum;
	
	@Column(unique = true, length = 50)
private String userId;

	@Column(length = 50)
private String userPassword;

	  @Column(columnDefinition = "TEXT")
private String userQuestion;
	
	  @Column(columnDefinition = "TEXT")
private String userAnswer;	
	  
public UserEntity(UserInputDto userInputDto) {
	  this.userId = userInputDto.getUserId();
	  this.userPassword = userInputDto.getUserPassword();
	  this.userQuestion = userInputDto.getUserQuestion();
	  this.userAnswer = userInputDto.getUserAnswer(); 
	
	  }

public void UserUpdate(UserRequestDto userRequestDto) {
	  this.userId = userRequestDto.getUserId();
	  this.userPassword = userRequestDto.getUserPassword();
	  this.userQuestion = userRequestDto.getUserQuestion();
	  this.userAnswer = userRequestDto.getUserAnswer();
}
public String getID() {
	return userId;
}
public String setID(String id) {
	return userId;
}
}
