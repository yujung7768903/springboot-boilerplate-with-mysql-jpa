package com.boilerplate.example.service;

import com.boilerplate.example.domain.user.User;
import com.boilerplate.example.domain.user.UserRepository;
import com.boilerplate.example.dto.user.UserSaveRequestDto;
import com.boilerplate.example.exception.DuplicateEmailException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(UserSaveRequestDto requestDto) {
        checkEmail(requestDto.getEmail());

        userRepository.save(requestDto.toEntity());
    }

    public void checkEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException("This email already exists");
        }
    }

}
