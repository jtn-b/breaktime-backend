package com.breaktime.backend.controller;

import com.breaktime.backend.dto.UserDataDto;
import com.breaktime.backend.entity.Category;
import com.breaktime.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {

    @Autowired
    CategoryService CategoryService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return CategoryService.getAllCategories();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category Category){
        return CategoryService.addCategory(Category);
    }



}
