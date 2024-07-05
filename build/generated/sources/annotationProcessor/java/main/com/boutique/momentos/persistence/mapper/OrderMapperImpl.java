package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.persistence.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T23:22:10-0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Red Hat, Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDomain toOrder(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDomain orderDomain = new OrderDomain();

        orderDomain.setDomainOrderId( order.getOrderId() );
        orderDomain.setDomainOrderPaymentMethod( order.getOrderPaymentMethod() );
        orderDomain.setDomainOrderLocation( order.getOrderLocation() );
        orderDomain.setDomainOrderCost( order.getOrderCost() );
        orderDomain.setDomainOrderProductId( order.getOrderProductId() );
        orderDomain.setDomainOrderUserId( order.getOrderUserId() );
        orderDomain.setDomainOrderStatus( order.isOrderStatus() );

        return orderDomain;
    }

    @Override
    public List<OrderDomain> toOrdersDomain(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDomain> list = new ArrayList<OrderDomain>( orders.size() );
        for ( Order order : orders ) {
            list.add( toOrder( order ) );
        }

        return list;
    }

    @Override
    public Order toDomainOrder(OrderDomain orderDomain) {
        if ( orderDomain == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderDomain.getDomainOrderId() );
        order.setOrderPaymentMethod( orderDomain.getDomainOrderPaymentMethod() );
        order.setOrderLocation( orderDomain.getDomainOrderLocation() );
        order.setOrderCost( orderDomain.getDomainOrderCost() );
        order.setOrderProductId( orderDomain.getDomainOrderProductId() );
        order.setOrderUserId( orderDomain.getDomainOrderUserId() );
        order.setOrderStatus( orderDomain.isDomainOrderStatus() );

        return order;
    }
}
