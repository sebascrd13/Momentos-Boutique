package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainentity.CartDomain;
import com.boutique.momentos.domain.domainrepository.CartDomainRepository;
import com.boutique.momentos.persistence.datarepository.CartDataRepository;
import com.boutique.momentos.persistence.entity.Cart;
import com.boutique.momentos.persistence.mapper.CartMapper;

@Repository
public class CartRepository implements CartDomainRepository {

    @Autowired
    private CartDataRepository cartDataRepository;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public CartDomain addProductToCart(Integer cartUserId, Integer cartProductId, Integer quantity) {
        Cart cart = new Cart();
        cart.setCartUserId(cartUserId);
        cart.setCartProductId(cartProductId);
        cart.setCartProductQuantity(quantity);

        Cart savedCart = cartDataRepository.save(cart);
        return cartMapper.toDomainCart(savedCart);
    }

    @Override
    public CartDomain updateProductQuantity(Integer userId, Integer productId, Integer newQuantity) {
        Optional<Cart> optionalCart = cartDataRepository.findByCartUserIdAndCartProductId(userId, productId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.setCartProductQuantity(newQuantity);
            Cart updatedCart = cartDataRepository.save(cart);
            return cartMapper.toDomainCart(updatedCart);
        } else {
            throw new RuntimeException("Product not found in cart");
        }
    }

    @Override
    public boolean removeProductFromCart(Integer userId, Integer productId) {
        Optional<Cart> optionalCart = cartDataRepository.findByCartUserIdAndCartProductId(userId, productId);
        if (optionalCart.isPresent()) {
            cartDataRepository.delete(optionalCart.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean clearCart(Integer userId) {
        List<Cart> cartItems = cartDataRepository.findByCartUserId(userId);
        if (!cartItems.isEmpty()) {
            cartDataRepository.deleteAll(cartItems);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CartDomain> getCartForUser(Integer userId) {
        List<Cart> cartItems = cartDataRepository.findByCartUserId(userId);
        return cartMapper.toCartsDomain(cartItems);
    }

    @Override
    public Optional<Integer> getProductQuantityInCart(Integer userId, Integer productId) {
        Optional<Cart> optionalCart = cartDataRepository.findByCartUserIdAndCartProductId(userId, productId);
        return optionalCart.map(Cart::getCartProductQuantity);
    }
}
