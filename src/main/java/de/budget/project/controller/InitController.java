package de.budget.project.controller;

import de.budget.project.model.dto.InitialDataDTO;
import de.budget.project.services.CategoryService;
import de.budget.project.services.InitialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class InitController {

    @Autowired
    InitialDataService initialDataService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/initdata/categories")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public InitialDataDTO getCategoryTypeList() {
        InitialDataDTO initialDataDTO = new InitialDataDTO(initialDataService.getCategoryTypes(),
                                            initialDataService.getCurrencyTypes(),
                                            categoryService.getAllCategories());
        return initialDataDTO;
    }



}
