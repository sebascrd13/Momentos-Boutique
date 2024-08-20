package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.OrderDomain;
import com.boutique.momentos.persistence.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-19T20:01:59-0600",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
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
        orderDomain.setDomainOrderLocation( order.getOrderLocation() );
        orderDomain.setDomainOrderProductId( order.getOrderProductId() );
        orderDomain.setDomainOrderUserId( order.getOrderUserId() );
        orderDomain.setDomainOrderStatus( order.getOrderStatus() );
        orderDomain.setDomainOrderPaymentId( order.getOrderPaymentId() );

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
        order.setOrderLocation( orderDomain.getDomainOrderLocation() );
        order.setOrderProductId( orderDomain.getDomainOrderProductId() );
        order.setOrderUserId( orderDomain.getDomainOrderUserId() );
        order.setOrderStatus( orderDomain.getDomainOrderStatus() );
        order.setOrderPaymentId( orderDomain.getDomainOrderPaymentId() );

        return order;
    }
}
