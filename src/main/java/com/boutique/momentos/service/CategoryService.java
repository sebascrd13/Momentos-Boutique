package com.boutique.momentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.domain.domainrepository.CategoryDomainRepository;

public class CategoryService {

    @Autowired
    private CategoryDomainRepository categoryDomainRepository;

    public List<CategoryDomain> getAll(){
        return categoryDomainRepository.getAll();
    }
    public CategoryDomain saveCategory(CategoryDomain category){
        return categoryDomainRepository.saveCategory(category);
    }
    public Optional<CategoryDomain> getCategoryById(int categoryId){
        return categoryDomainRepository.getCategoryById(categoryId);
    }
    public boolean updateCategory(CategoryDomain domainCategory){
        if (getCategoryById(domainCategory.getDomainCategoryId()).isPresent()) {
            categoryDomainRepository.updateCategory(domainCategory);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteCategory(int domainCategoryId){
        if (getCategoryById(domainCategoryId).isPresent()){
            categoryDomainRepository.deleteCategory(domainCategoryId);
            return true;
        } else {
            return false;
        }
    }
}
