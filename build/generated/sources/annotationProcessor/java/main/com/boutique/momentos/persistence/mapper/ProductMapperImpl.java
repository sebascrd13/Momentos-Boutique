package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.persistence.entity.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T16:12:03-0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Red Hat, Inc.)"
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
        byte[] domainProductImageData = product.getProductImageData();
        if ( domainProductImageData != null ) {
            productDomain.setDomainProductImageData( Arrays.copyOf( domainProductImageData, domainProductImageData.length ) );
        }
        productDomain.setDomainProductStatus( product.isProductStatus() );

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
        byte[] productImageData = productDomain.getDomainProductImageData();
        if ( productImageData != null ) {
            product.setProductImageData( Arrays.copyOf( productImageData, productImageData.length ) );
        }
        product.setProductStatus( productDomain.isDomainProductStatus() );

        return product;
    }
}
