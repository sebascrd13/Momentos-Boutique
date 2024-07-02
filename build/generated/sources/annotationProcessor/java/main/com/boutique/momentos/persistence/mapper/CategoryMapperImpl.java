package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.CategoryDomain;
import com.boutique.momentos.persistence.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T16:12:02-0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Red Hat, Inc.)"
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
