package com.boutique.momentos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.persistence.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
        @Mapping(source = "productId", target = "domainProductId"),
        @Mapping(source = "productName", target = "domainProductName"),
        @Mapping(source = "productDescription", target = "domainProductDescription"),
        @Mapping(source = "productPrice", target = "domainProductPrice"),
        @Mapping(source = "productStock", target = "domainProductStock"),
        @Mapping(source = "productCategoryId", target = "domainProductCategoryId"),
        @Mapping(source = "productUserId", target = "domainProductUserId"),
        @Mapping(source = "productImagePath", target = "domainProductImagePath"),
        @Mapping(source = "productSize", target = "domainProductSize"),
        @Mapping(source = "productStatus", target = "domainProductStatus"),
    })

    ProductDomain toProduct (Product product);

    List<ProductDomain> toProductsDomain (List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Product toDomainProduct (ProductDomain productDomain);
}
