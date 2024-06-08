package com.example.demo;

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
public class ApiApplication {
	
	public static void main(String[] args) {
		VertexAI vertexAI = new VertexAI("vertexai1-425802", "asia-northeast3");
		    GenerateContentResponse response;

		    GenerativeModel model = new GenerativeModel("gemini-pro", vertexAI);
		    ChatSession chatSession = new ChatSession(model);

		    try {
				response = chatSession.sendMessage("Can I get some words for explain Rokey Mountain?.");
				System.out.println(ResponseHandler.getText(response));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

