package com.simple.photo.userJson;

import com.simple.photo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserJson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long JsonId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "UserNum")
	private User user;
	
	@Column(columnDefinition = "JSON")
	private String JsonFile;
	
	@Column(columnDefinition = "TEXT")
	private String JsonName;
}
