package com.boutique.momentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.CartDomain;
import com.boutique.momentos.domain.domainrepository.CartDomainRepository;

@Service
public class CartService {

    @Autowired
    private CartDomainRepository cartDomainRepository;

    public CartDomain addProductToCart(Integer userId, Integer productId, Integer quantity){
        return cartDomainRepository.addProductToCart(userId, productId, quantity);
    }

    public CartDomain updateProductQuantity(Integer userId, Integer productId, Integer newQuantity){
        return cartDomainRepository.updateProductQuantity(userId, productId, newQuantity);
    }

    public boolean removeProductFromCart(Integer userId, Integer productId){
        return cartDomainRepository.removeProductFromCart(userId, productId);
    }
    public boolean clearCart(Integer userId){
        return cartDomainRepository.clearCart(userId);
    }
    public List<CartDomain> getCartForUser(Integer userId){
        return cartDomainRepository.getCartForUser(userId);
    }
    public Optional<Integer> getProductQuantityInCart(Integer userId, Integer productId){
        return cartDomainRepository.getProductQuantityInCart(userId, productId);
    }
}
