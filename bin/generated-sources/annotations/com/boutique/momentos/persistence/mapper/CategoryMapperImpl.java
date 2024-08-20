package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.persistence.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-19T15:01:34-0600",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDomain toCategory(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDomain categoryDomain = new CategoryDomain();

        categoryDomain.setDomainCategoryId( category.getCategoryId() );
        categoryDomain.setDomainCategoryName( category.getCategoryName() );

        return categoryDomain;
    }

    @Override
    public List<CategoryDomain> toCategoriesDomain(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDomain> list = new ArrayList<CategoryDomain>( categories.size() );
        for ( Category category : categories ) {
            list.add( toCategory( category ) );
        }

        return list;
    }

    @Override
    public Category toDomainCategory(CategoryDomain categoryDomain) {
        if ( categoryDomain == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDomain.getDomainCategoryId() );
        category.setCategoryName( categoryDomain.getDomainCategoryName() );

        return category;
    }
}
