package com.gin.job_tracker.formbean;

import com.gin.job_tracker.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpFormBean {

    private Integer id;

    @NotEmpty(message = "Username is required.")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email does not match its format.")
    @NotEmpty(message = "Email is required.")
    @EmailUnique(message = "Email is already taken.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$", message = "Password must be strong.")
    @NotEmpty(message = "Password is required.")
    private String password;

}
