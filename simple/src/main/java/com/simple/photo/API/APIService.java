package com.simple.photo.API;
// APIService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.api.client.util.Value;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class APIService {
 @Qualifier("APIiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${gemini.api.url}")
    private String apiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String getContents(String prompt) {

        // Gemini에 요청 전송
        String requestUrl = apiUrl + "?key=" + geminiApiKey;

        APIRequest request = new APIRequest(prompt);
        APIResponse response = restTemplate.postForObject(requestUrl, request, APIResponse.class);

        String message = response.getCandidates().get(0).getContent().getParts().get(0).getText().toString();

        return message;
    }
}
