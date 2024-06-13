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
	
	private Set<String> idcheck = new HashSet<>();
	public ResponseDto<?> create(UserInputDto userInputDto) {
		String UserId = userInputDto.getUserId();
		String UserPassword = userInputDto.getUserPassword();
		String UserPasswordConfirm = userInputDto.getUserPasswordConfirm();
		
		if (!idcheck.contains(UserId))
			idcheck.add(UserId);
		
		try {
			if (idcheck.contains(UserId))
				return ResponseDto.setFailed("중복된 ID입니다.");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
		}
		
		if (!UserPassword.equals(UserPasswordConfirm))
			return ResponseDto.setFailed("비밀번호가 일치하지 않습니다.");
		
		User user = new User(userInputDto);
		
		try {
			userRepository.save(user);
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseDto.setFailed("데이터베이스 연결에 실패하였습니다.");
		}
		return ResponseDto.setSuccess("회원가입이 완료되었습니다.");
	}
	 @Transactional
	public List<User> getList(){
		return this.userRepository.findAll();
	}

	 public ResponseDto<?> modify(UserInputDto userInputDto){
		 User user = new User();
		 Long UserNum = userInputDto.getUserNum();
		String UserPassword = "";
		String UserPasswordConfirm = userInputDto.getUserPasswordConfirm();
		String UserNewPassword = userInputDto.getUserNewPassword();
		String UserNewPasswordConfirm = userInputDto.getUserNewPasswodConfirm();
		 Optional<User> usero= userRepository.findById(UserNum);
		 if (usero.isPresent()) {
	            UserPassword = usero.get().getUserPassword();
	        } else {
	            throw new DataNotFoundException("해당유저의 정보가 없습니다");
	        }	
		 if (!UserPassword.equals(UserPasswordConfirm))
				return ResponseDto.setFailed("기존 비밀번호가 일치하지 않습니다.");
		 
		 if (!UserNewPassword.equals(UserNewPasswordConfirm))
				return ResponseDto.setFailed("새로운 비밀번호가 일치하지 않습니다.");
		 
		 String UsernewQuestion = userInputDto.getUserQuestion();
		 String UsernewAnswer = userInputDto.getUserAnswer();
			
			try {
				user.setUserNum(UserNum);
				user.setUserId(usero.get().getUserId());
				user.setUserPassword(UserNewPassword);
				user.setUserQuestion(UsernewQuestion);
				user.setUserAnswer(UsernewAnswer);
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
}
