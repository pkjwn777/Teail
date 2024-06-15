package com.apitest2;

import java.io.IOException;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import com.google.cloud.vertexai.generativeai.ResponseStream; 

@SpringBootApplication
public class Apitest2Application {

	public static void main(String[] args) throws IOException {
		VertexAI vertexAI = new VertexAI("vertexai1-425802", "asia-northeast3");	// gemini 호출 객체
		
		GenerativeModel model = new GenerativeModel("gemini-pro-vision", vertexAI);	// gemini 호출 시 사용될 모델 설정, 이미지 사용을 위해 gemini-pro-vision 사용
		// 이미지 없이 텍스트만 사용 시 이전처럼 gemini-pro 사용
		
		GenerateContentResponse response = model.generateContent(	//응답 내용을 받을 변수 response
		ContentMaker.fromMultiModalData(	//입력 데이터에 따른 알맞은 답변 형식 받을 것
				PartMaker.fromMimeTypeAndData("image/png", "gs://client_repuest_image/ajlkdfjoiel.png"),	// 매개변수(전송할 미디어타입 "image/png" : 이미지 형식의 미디어 타입 전송, 이미지 바이트나 이미지 url, 질문할 내용을 담은 텍스트) 
		          "이미지를 설명할 명사 다섯개")
		        );

		    System.out.println(ResponseHandler.getText(response)); // 받아온 응답(텍스트 메세지 한정, getContent 형식도 존재)을 response에 담아 출력 - 답변을 가져올 때 해당 메소드 사
		    
	}
}
