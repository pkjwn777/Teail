package com.simple.photo.userJson;

import org.json.simple.JSONObject;

import com.simple.photo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class UserJson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long JsonId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "UserNum")
	private Long UserNum;
	
	@Column(columnDefinition = "JSON")
	private JSONObject JsonFile;
	
	@Column(columnDefinition = "TEXT")
	private String JsonName;
}
