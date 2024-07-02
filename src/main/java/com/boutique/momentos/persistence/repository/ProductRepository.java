package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.domain.domainrepository.ProductDomainRepository;
import com.boutique.momentos.persistence.datarepository.ProductDataRepository;
import com.boutique.momentos.persistence.entity.Product;
import com.boutique.momentos.persistence.mapper.ProductMapper;

import jakarta.transaction.Transactional;

@Repository
public class ProductRepository implements ProductDomainRepository {

    @Autowired
    private ProductDataRepository productDataRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public List<ProductDomain> getAll() {
        List<Product> products = (List<Product>) productDataRepository.findAll();
        return productMapper.toProductsDomain(products);
    }

    @Override
    public ProductDomain saveProduct(ProductDomain domainProduct) {
        Product product = productMapper.toDomainProduct(domainProduct);
        return productMapper.toProduct(productDataRepository.save(product));
    }

    @Override
    public Optional<ProductDomain> getProductById(int domainProductId) {
        return productDataRepository.findById(domainProductId).map(product -> productMapper.toProduct(product));
    }

    @Override
    @Transactional
    public void updateProduct(ProductDomain productDomain) {
        Product product = productMapper.toDomainProduct(productDomain);
        if (productDataRepository.existsById(product.getProductId())) {
            productDataRepository.save(product);
        } else {
            throw new IllegalArgumentException("No hay un producto con el id: " + product.getProductId());
        }
    }

    @Override
    @Transactional
    public void deleteProduct(int domainProductId) {
        productDataRepository.deleteById(domainProductId);
    }
}
