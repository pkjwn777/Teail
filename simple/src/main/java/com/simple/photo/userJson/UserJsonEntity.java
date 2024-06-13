package com.simple.photo.userJson;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Primary;

import com.simple.photo.user.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Entity(name = "userJson")
public class UserJsonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jsonId;
	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "userNum")
	@Column
	private Long userNum;
	
	@Column(columnDefinition = "JSON")
	private JSONObject jsonFile;
	
	public UserJsonEntity(UserJsonInputDto userJsonInputDto) {
		this.userNum = userJsonInputDto.getUserNum();
		this.jsonFile = userJsonInputDto.getJsonFile();
	}
}
