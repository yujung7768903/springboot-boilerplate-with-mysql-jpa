package com.boilerplate.example.controller;

import com.boilerplate.example.dto.user.UserSaveRequestDto;
import com.boilerplate.example.exception.DuplicateEmailException;
import com.boilerplate.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> signup(@Valid @RequestBody UserSaveRequestDto requestDto) {
        try {
            userService.signup(requestDto);
            return ResponseEntity.status(201).body("Signup successful");
        } catch (DuplicateEmailException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
