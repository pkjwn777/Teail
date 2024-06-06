package com.simple.photo.API;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gemini")

public class APIController {
  private final APIService apiService;

    @GetMapping("/chat")
    public ResponseEntity<?> gemini() {
        try {
            return ResponseEntity.ok().body(APIService.getContents("안녕! 너는 누구야?"));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
