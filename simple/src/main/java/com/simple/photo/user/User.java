package com.simple.photo.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
	
}
