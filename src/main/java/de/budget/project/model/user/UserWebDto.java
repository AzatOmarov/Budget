package de.budget.project.model.user;

import lombok.Data;

@Data
public class UserWebDto {
    private String name;
    private String password;
    private String email;
}