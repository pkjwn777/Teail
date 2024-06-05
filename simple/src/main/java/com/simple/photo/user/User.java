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
private Long user_num;
	
	@Column(unique = true, length = 50)
private String user_id;

	@Column(length = 50)
private String user_password;

	  @Column(columnDefinition = "TEXT")
private String user_question;
	
	  @Column(columnDefinition = "TEXT")
	private String user_answer;
	
}
