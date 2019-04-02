package de.budget.project.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWebResponse {
    private String name;
    private String email;
}