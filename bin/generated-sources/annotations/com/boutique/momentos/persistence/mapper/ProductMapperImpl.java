package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.persistence.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T23:21:10-0600",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDomain toProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDomain productDomain = new ProductDomain();

        productDomain.setDomainProductId( product.getProductId() );
        productDomain.setDomainProductName( product.getProductName() );
        productDomain.setDomainProductDescription( product.getProductDescription() );
        productDomain.setDomainProductPrice( product.getProductPrice() );
        productDomain.setDomainProductStock( product.getProductStock() );
        productDomain.setDomainProductCategoryId( product.getProductCategoryId() );
        productDomain.setDomainProductUserId( product.getProductUserId() );
        productDomain.setDomainProductImagePath( product.getProductImagePath() );
        productDomain.setDomainProductSize( product.getProductSize() );
        productDomain.setDomainProductStatus( product.getProductStatus() );

        return productDomain;
    }

    @Override
    public List<ProductDomain> toProductsDomain(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDomain> list = new ArrayList<ProductDomain>( products.size() );
        for ( Product product : products ) {
            list.add( toProduct( product ) );
        }

        return list;
    }

    @Override
    public Product toDomainProduct(ProductDomain productDomain) {
        if ( productDomain == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productDomain.getDomainProductId() );
        product.setProductName( productDomain.getDomainProductName() );
        product.setProductDescription( productDomain.getDomainProductDescription() );
        product.setProductPrice( productDomain.getDomainProductPrice() );
        product.setProductStock( productDomain.getDomainProductStock() );
        product.setProductCategoryId( productDomain.getDomainProductCategoryId() );
        product.setProductUserId( productDomain.getDomainProductUserId() );
        product.setProductImagePath( productDomain.getDomainProductImagePath() );
        product.setProductSize( productDomain.getDomainProductSize() );
        product.setProductStatus( productDomain.getDomainProductStatus() );

        return product;
    }
}
