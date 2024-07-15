package com.boutique.momentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.momentos.domain.domainentity.ProductDomain;
import com.boutique.momentos.domain.domainrepository.ProductDomainRepository;

@Service
public class ProductService {

    @Autowired
    private ProductDomainRepository productDomainRepository;

    public List<ProductDomain> getAll(){
        return productDomainRepository.getAll();
    }
    public ProductDomain saveProduct(ProductDomain domainProduct){
        return productDomainRepository.saveProduct(domainProduct);
    }
    public Optional<ProductDomain> getProductById(int domainProductId){
        return productDomainRepository.getProductById(domainProductId);
    }
    public ProductDomain updateProduct(ProductDomain productDomain){
        Optional<ProductDomain> existingProduct = getProductById(productDomain.getDomainProductId());
        if (existingProduct.isPresent()) {
            productDomainRepository.updateProduct(productDomain);
            return productDomain;
        } else {
            throw new RuntimeException("Product not found");
        }
    }
    
    public boolean deleteProduct(int domainProductId){
        if (getProductById(domainProductId).isPresent()){
            productDomainRepository.deleteProduct(domainProductId);
            return true;
        } else {
            return false;
        }
    }
}
