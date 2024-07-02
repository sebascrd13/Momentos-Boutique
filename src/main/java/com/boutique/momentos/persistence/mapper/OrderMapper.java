package com.boutique.momentos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.persistence.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mappings({
        @Mapping(source = "orderId", target = "domainOrderId"),
        @Mapping(source = "orderPaymentMethod", target = "domainOrderPaymentMethod"),
        @Mapping(source = "orderLocation", target = "domainOrderLocation"),
        @Mapping(source = "orderCost", target = "domainOrderCost"),
        @Mapping(source = "orderProductId", target = "domainOrderProductId"),
        @Mapping(source = "orderUserId", target = "domainOrderUserId"),
        @Mapping(source = "orderStatus", target = "domainOrderStatus"),
    })

    OrderDomain toOrder (Order order);

    List<OrderDomain> toOrdersDomain (List<Order> orders);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "user", ignore = true)
    Order toDomainOrder (OrderDomain orderDomain);
}
