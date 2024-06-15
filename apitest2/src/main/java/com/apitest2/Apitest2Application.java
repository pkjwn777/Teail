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

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;

@SpringBootApplication
public class Apitest2Application {

	public static void main(String[] args) throws IOException {
		VertexAI vertexAI = new VertexAI("vertexai1-425802", "asia-northeast3");
		
		GenerativeModel model = new GenerativeModel("gemini-pro-vision", vertexAI);
		
		GenerateContentResponse response = model.generateContent(
		ContentMaker.fromMultiModalData(
				PartMaker.fromMimeTypeAndData("image/png", "gs://client_repuest_image/ajlkdfjoiel.png"),
		          "이미지를 설명할 명사 다섯개")
		        );

		    System.out.println(ResponseHandler.getText(response));
		    
	}
}
