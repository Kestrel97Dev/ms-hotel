package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.CategoryModel;
import com.camilo.hotel_back.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<CategoryModel> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Optional<CategoryModel> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryRepository.save(categoryModel);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
