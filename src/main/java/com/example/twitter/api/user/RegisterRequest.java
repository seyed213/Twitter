package com.example.twitter.api.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank
    private String userName;

    @Size(min = 6, max = 100)
    private String password;

    @Email
    private String email;

    @Size(min = 11, max = 11)
    private String phoneNumber;
}
