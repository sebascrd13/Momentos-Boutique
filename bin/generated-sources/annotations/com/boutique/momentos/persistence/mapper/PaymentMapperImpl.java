package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.persistence.entity.Payment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T16:15:31-0600",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDomain toPayment(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDomain paymentDomain = new PaymentDomain();

        paymentDomain.setDomainIdPayment( payment.getIdPayment() );
        paymentDomain.setDomainIdUser( payment.getIdUser() );
        paymentDomain.setDomainImageData( payment.getImageData() );
        paymentDomain.setDomainPaymentDate( payment.getPaymentDate() );
        paymentDomain.setDomainPaymentStatus( payment.isPaymentStatus() );
        paymentDomain.setDomainPaymentMethod( payment.getPaymentMethod() );
        paymentDomain.setDomainPaymentTotalCost( payment.getPaymentTotalCost() );

        return paymentDomain;
    }

    @Override
    public List<PaymentDomain> toPaymentsDomain(List<Payment> payments) {
        if ( payments == null ) {
            return null;
        }

        List<PaymentDomain> list = new ArrayList<PaymentDomain>( payments.size() );
        for ( Payment payment : payments ) {
            list.add( toPayment( payment ) );
        }

        return list;
    }

    @Override
    public Payment toDomainPayment(PaymentDomain paymentDomain) {
        if ( paymentDomain == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setIdPayment( paymentDomain.getDomainIdPayment() );
        payment.setIdUser( paymentDomain.getDomainIdUser() );
        payment.setImageData( paymentDomain.getDomainImageData() );
        payment.setPaymentDate( paymentDomain.getDomainPaymentDate() );
        payment.setPaymentStatus( paymentDomain.isDomainPaymentStatus() );
        payment.setPaymentMethod( paymentDomain.getDomainPaymentMethod() );
        payment.setPaymentTotalCost( paymentDomain.getDomainPaymentTotalCost() );

        return payment;
    }
}
