package de.budget.project.model.web;

import lombok.Data;

@Data
public class UserWebRequest {
    private String name;
    private String password;
    private String email;
}