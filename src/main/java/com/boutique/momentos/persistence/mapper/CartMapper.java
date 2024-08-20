package com.boutique.momentos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.boutique.momentos.domain.domainentity.CartDomain;
import com.boutique.momentos.persistence.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mappings({
        @Mapping(source = "cartId", target = "domainCartId"),
        @Mapping(source = "cartUserId", target = "domainCartUserId"),
        @Mapping(source = "cartProductId", target = "domainCartProductId"),
        @Mapping(source = "cartProductQuantity", target = "domainCartProductQuantity"),
    })

    CartDomain toDomainCart (Cart cart);

    List<CartDomain> toCartsDomain (List<Cart> carts);

    @InheritInverseConfiguration
    Cart toCart (CartDomain cartDomain);
}
