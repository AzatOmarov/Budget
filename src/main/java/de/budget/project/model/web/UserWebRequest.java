package de.budget.project.model.web;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserWebRequest {

    @NotNull
    @Size(max = 50)
    @NotBlank
    private String name;

    @NotNull
    @Size(min = 5, max =50,
          message = "Password must contain: 5-8 charachters," +
                    "at least: 1 Uppercase & 1 Lowercase," +
                    "1 Number" +
                    "and at least one special symbol !@#$%^&*_=+-")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{5,8}$")
    private String password;

    @NotNull
    @Size(max = 50)
    @Email(regexp = ".+@.+\\...+")
    private String email;
}