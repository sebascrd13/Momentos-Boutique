package com.boutique.momentos.domain.domainrepository;

import com.boutique.momentos.persistence.entity.OrderProduct;

import java.util.List;

public interface OrderProductDomainRepository {
    List<OrderProduct> getOrderProductsByOrderId(int orderId);
    OrderProduct createOrderProduct(int orderId, OrderProduct orderProduct);
}
