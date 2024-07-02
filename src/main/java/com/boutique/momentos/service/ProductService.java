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
    public boolean updateProduct(ProductDomain productDomain){
        if (getProductById(productDomain.getDomainProductId()).isPresent()) {
            productDomainRepository.updateProduct(productDomain);
            return true;
        } else {
            return false;
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
