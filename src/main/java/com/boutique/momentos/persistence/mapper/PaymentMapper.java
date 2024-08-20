package com.boutique.momentos.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.persistence.entity.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mappings({
        @Mapping(source = "idPayment", target = "domainIdPayment"),
        @Mapping(source = "idUser", target = "domainIdUser"),
        @Mapping(source = "imageData", target = "domainImageData"),
        @Mapping(source = "paymentDate", target = "domainPaymentDate"),
        @Mapping(source = "paymentStatus", target = "domainPaymentStatus"),
        @Mapping(source = "paymentMethod", target = "domainPaymentMethod"),
        @Mapping(source = "paymentTotalCost", target = "domainPaymentTotalCost"),
    })

    PaymentDomain toPayment (Payment payment);

    List<PaymentDomain> toPaymentsDomain (List<Payment> payments);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    Payment toDomainPayment (PaymentDomain paymentDomain);
}
