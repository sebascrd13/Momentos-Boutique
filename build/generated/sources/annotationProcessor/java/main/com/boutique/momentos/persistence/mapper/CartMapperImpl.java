package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.CartDomain;
import com.boutique.momentos.persistence.entity.Cart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-19T13:50:40-0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Red Hat, Inc.)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDomain toDomainCart(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDomain cartDomain = new CartDomain();

        cartDomain.setDomainCartId( cart.getCartId() );
        cartDomain.setDomainCartUserId( cart.getCartUserId() );
        cartDomain.setDomainCartProductId( cart.getCartProductId() );
        cartDomain.setDomainCartProductQuantity( cart.getCartProductQuantity() );

        return cartDomain;
    }

    @Override
    public List<CartDomain> toCartsDomain(List<Cart> carts) {
        if ( carts == null ) {
            return null;
        }

        List<CartDomain> list = new ArrayList<CartDomain>( carts.size() );
        for ( Cart cart : carts ) {
            list.add( toDomainCart( cart ) );
        }

        return list;
    }

    @Override
    public Cart toCart(CartDomain cartDomain) {
        if ( cartDomain == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartDomain.getDomainCartId() );
        cart.setCartUserId( cartDomain.getDomainCartUserId() );
        cart.setCartProductId( cartDomain.getDomainCartProductId() );
        cart.setCartProductQuantity( cartDomain.getDomainCartProductQuantity() );

        return cart;
    }
}
