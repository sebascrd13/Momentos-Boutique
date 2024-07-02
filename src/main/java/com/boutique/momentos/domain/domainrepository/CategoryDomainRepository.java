package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.CategoryDomain;

public interface CategoryDomainRepository {
    List<CategoryDomain> getAll();
    CategoryDomain saveCategory(CategoryDomain category);
    Optional<CategoryDomain> getCategoryById(int categoryId);
    void updateCategory(CategoryDomain category);
    void deleteCategory(int categoryId);
}
