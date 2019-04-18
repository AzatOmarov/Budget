package de.budget.project.model.web;

import lombok.Data;

@Data
public class UserWebResponse {
    private Long id;
    private String name;
    private String email;
}