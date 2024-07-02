package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.domain.domainrepository.CategoryDomainRepository;
import com.boutique.momentos.persistence.datarepository.CategoryDataRepository;
import com.boutique.momentos.persistence.entity.Category;
import com.boutique.momentos.persistence.mapper.CategoryMapper;

import jakarta.transaction.Transactional;

public class CategoryRepository implements CategoryDomainRepository {

    @Autowired
    private CategoryDataRepository categoryDataRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDomain> getAll() {
        List<Category> categories = (List<Category>) categoryDataRepository.findAll();
        return categoryMapper.toCategoriesDomain(categories);
    }

    @Transactional
    @Override
    public CategoryDomain saveCategory(CategoryDomain domainCategory) {
        Category category = categoryMapper.toDomainCategory(domainCategory);
        return categoryMapper.toCategory(categoryDataRepository.save(category));
    }

    @Override
    public Optional<CategoryDomain> getCategoryById(int domainCategoryId) {
        return categoryDataRepository.findById(domainCategoryId).map(category -> categoryMapper.toCategory(category));
    }

    @Transactional
    @Override
    public void updateCategory(CategoryDomain domainCategory) {
        Category category = categoryMapper.toDomainCategory(domainCategory);
        if (categoryDataRepository.existsById(category.getCategoryId())) {
            categoryDataRepository.save(category);
        } else {
            throw new IllegalArgumentException("No hay una categoria con el id: " + category.getCategoryId());
        }
    }

    @Transactional
    @Override
    public void deleteCategory(int domainCategoryId) {
        categoryDataRepository.deleteById(domainCategoryId);
    }
}
