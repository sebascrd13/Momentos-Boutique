package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.domain.domainrepository.ProductDomainRepository;
import com.boutique.momentos.persistence.datarepository.ProductDataRepository;
import com.boutique.momentos.persistence.entity.Payment;
import com.boutique.momentos.persistence.entity.Product;
import com.boutique.momentos.persistence.mapper.ProductMapper;

public class ProductRepository implements ProductDomainRepository {

    @Autowired
    private ProductDataRepository productDataRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> products = (List<Product>) productDataRepository.findAll();
        return productMapper.toProductsDomain(products);
    }

    @Override
    public ProductDomain saveProduct(ProductDomain product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProduct'");
    }

    @Override
    public Optional<ProductDomain> getProductById(int productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public void updateProduct(ProductDomain product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public void deleteProduct(int productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    } 
    
}
