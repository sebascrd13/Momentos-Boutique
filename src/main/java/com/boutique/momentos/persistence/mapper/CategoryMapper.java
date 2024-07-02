package com.boutique.momentos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "categoryId", target = "domainCategoryId"),
        @Mapping(source = "categoryName", target = "domainCategoryName"),
    })

    CategoryDomain toCategory (Category category);

    List<CategoryDomain> toCategoriesDomain (List<Category> categories);

    @InheritInverseConfiguration
    Category toDomainCategory (CategoryDomain categoryDomain);
}
