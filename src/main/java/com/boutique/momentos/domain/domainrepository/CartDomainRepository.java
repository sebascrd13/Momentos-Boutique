package com.boutique.momentos.domain.domainrepository;

import com.boutique.momentos.domain.domainentity.CartDomain;
import java.util.List;
import java.util.Optional;

public interface CartDomainRepository {
    CartDomain addProductToCart(Integer userId, Integer productId, Integer quantity);
    CartDomain updateProductQuantity(Integer userId, Integer productId, Integer newQuantity);
    boolean removeProductFromCart(Integer userId, Integer productId);
    boolean clearCart(Integer userId);
    List<CartDomain> getCartForUser(Integer userId);
    Optional<Integer> getProductQuantityInCart(Integer userId, Integer productId);
}
