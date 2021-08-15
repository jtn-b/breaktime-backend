package com.breaktime.backend.service;

import com.breaktime.backend.entity.Category;
import com.breaktime.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository CategoryRepository;

    @PostConstruct
    public void initDB(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Football"));
        categories.add(new Category(2,"Yoga"));
        categories.add(new Category(3,"Music"));

        CategoryRepository.saveAll(categories);
    }

    public List<Category> getAllCategories(){
        return CategoryRepository.findAll();
    }

    public Category addCategory(Category category){
        CategoryRepository.save(category);
        return category;
    }

    public Category addCategory(int id,String categoryName)
    {
        Category ctg = new Category(id,categoryName);
        CategoryRepository.save(ctg);
        return ctg;
    }
}
