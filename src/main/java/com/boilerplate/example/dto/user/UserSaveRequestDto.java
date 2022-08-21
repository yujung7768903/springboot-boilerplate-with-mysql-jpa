package com.boilerplate.example.dto.user;

import com.boilerplate.example.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email format is not valid")
    private String email;

    @Builder
    public UserSaveRequestDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }

}
