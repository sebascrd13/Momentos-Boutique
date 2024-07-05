package com.boutique.momentos.presentation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDomain>> getAllCategories() {
        List<CategoryDomain> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<CategoryDomain> saveCategory(@RequestParam("categoryId") int categoryId,
                                                    @RequestParam("categoryName") String categoryName) {
        try {
            CategoryDomain categoryDomain = new CategoryDomain();
            categoryDomain.setDomainCategoryName(categoryName);
            categoryDomain.setDomainCategoryId(categoryId);

            CategoryDomain savedCategory = categoryService.saveCategory(categoryDomain);

            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDomain> getCategoryById(@PathVariable("id") int id) {
        Optional<CategoryDomain> category = categoryService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDomain> updateCategory(@PathVariable("id") int id,
                                                         @RequestBody CategoryDomain categoryDomain) {
        if (categoryService.getCategoryById(id).isPresent()) {
            categoryDomain.setDomainCategoryId(id);
            boolean updated = categoryService.updateCategory(categoryDomain);
            if (updated) {
                return new ResponseEntity<>(categoryDomain, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
