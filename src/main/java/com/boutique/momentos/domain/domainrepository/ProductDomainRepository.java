package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.ProductDomain;

public interface ProductDomainRepository {
    List<ProductDomain> getAll();
    ProductDomain saveProduct(ProductDomain product);
    Optional<ProductDomain> getProductById(int productId);
    void updateProduct(ProductDomain product);
    void deleteProduct(int productId);
}
