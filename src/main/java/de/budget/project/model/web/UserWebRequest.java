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
          message = "The password reqiurements: password must be 5-8 charachters long," +
                    "at least 1 Uppercase & 1 Lowercase," +
                    "at least 1 Number" +
                    "and at least one special symbol !@#$%^&*_=+-")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{5,8}$")
    private String password;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = ".+@.+\\...+")
    private String email;
}