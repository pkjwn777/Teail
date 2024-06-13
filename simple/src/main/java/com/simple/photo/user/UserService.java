package com.simple.photo.user;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.photo.DataNotFoundException;
import com.simple.photo.ResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired UserRepository userRepository;
	
	public Boolean IDcheck (String userID) {
		Set<String>Idset = new HashSet<>();
		for (UserEntity list : getList()) {
			Idset.add(list.getUserId());
		}
		if (Idset.contains(userID))
			return true;
		else
			return false;
		
	}
	public ResponseDto<?> create(UserInputDto userInputDto) {
		
		String userId = userInputDto.getUserId();
		String userPassword = userInputDto.getUserPassword();
		String userPasswordConfirm = userInputDto.getUserPasswordConfirm();
		
		
		try {
			if (IDcheck(userId))
				return ResponseDto.setFailed("중복된 ID입니다.");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
		}
		
		if (!userPassword.equals(userPasswordConfirm))
			return ResponseDto.setFailed("비밀번호가 일치하지 않습니다.");
		
		UserEntity user = new UserEntity(userInputDto);
		
		try {
			userRepository.save(user);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
		}
		return ResponseDto.setSuccess("회원가입이 완료되었습니다.");
	}
	 
	public List<UserEntity> getList(){
		return this.userRepository.findAll();
	}

	 public ResponseDto<?> modify(UserInputDto userInputDto){
		 UserEntity user = new UserEntity(userInputDto);
		 Long userNum = userInputDto.getUserNum();
		String userPassword = "";
		String userPasswordConfirm = userInputDto.getUserPasswordConfirm();
		String userNewPassword = userInputDto.getUserNewPassword();
		String userNewPasswordConfirm = userInputDto.getUserNewPasswodConfirm();
		 Optional<UserEntity> usero= userRepository.findById(userNum);
		 if (usero.isPresent()) {
	            userPassword = usero.get().getUserPassword();
	        } else {
	            throw new DataNotFoundException("해당유저의 정보가 없습니다");
	        }	
		 if (!userPassword.equals(userPasswordConfirm))
				return ResponseDto.setFailed("기존 비밀번호가 일치하지 않습니다.");
		 
		 if (!userNewPassword.equals(userNewPasswordConfirm))
				return ResponseDto.setFailed("새로운 비밀번호가 일치하지 않습니다.");
		 
		 String usernewQuestion = userInputDto.getUserQuestion();
		 String usernewAnswer = userInputDto.getUserAnswer();
			
			try {
				user.setUserNum(userNum);
				user.setUserId(usero.get().getUserId());
				user.setUserPassword(userNewPassword);
				user.setUserQuestion(usernewQuestion);
				user.setUserAnswer(usernewAnswer);
				userRepository.save(user);
			}catch (Exception e) {
				// TODO: handle exception
				return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
			}
			return ResponseDto.setSuccess("회원수정이 완료되었습니다.");
	 }
	 
	 public ResponseDto<?> delete(UserInputDto userInputDto){
		 String UserPassword = userInputDto.getUserPassword();
		 String UserPasswordConfirm = userInputDto.getUserPasswordConfirm();
		 Long UserNum = userInputDto.getUserNum();
		 if (!UserPasswordConfirm.equals(UserPassword))
				return ResponseDto.setFailed("비밀번호가 일치하지 않습니다.");
		 
		 if (!userInputDto.getYn())
			 return ResponseDto.setSuccess("회원탈퇴가 취소되었습니다.");
		 
		 try {
			 userRepository.deleteById(UserNum);
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
		}
		 return ResponseDto.setSuccess("회원탈퇴가 완료되었습니다.");
	 }
	 public Optional<UserEntity> getUserByNum(Long userNum){
		 return this.userRepository.findById(userNum);
	 }
}
