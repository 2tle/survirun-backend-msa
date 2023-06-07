package com.develog.auth.controller

import com.develog.auth.dto.TestDTO
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
class AuthController {
    @GetMapping("/test")
    fun test(): ResponseEntity<TestDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(TestDTO("Hello"))
    }
}