package com.simple.photo.API;
// GeminiService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.api.client.util.Value;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
 @Qualifier("apiiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${gemini.api.url}")
    private String apiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String getContents(String prompt) {

        // Gemini에 요청 전송
        String requestUrl = apiUrl + "?key=" + geminiApiKey;

        apiRequest request = new apiRequest(prompt);
        apiResponse response = restTemplate.postForObject(requestUrl, request, apiResponse.class);

        String message = response.getCandidates().get(0).getContent().getParts().get(0).getText().toString();

        return message;
    }
}
