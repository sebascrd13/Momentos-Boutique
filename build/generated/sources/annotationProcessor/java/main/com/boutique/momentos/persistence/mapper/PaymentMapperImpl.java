package com.boutique.momentos.persistence.mapper;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.persistence.entity.Payment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T16:12:38-0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.1 (Red Hat, Inc.)"
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
        byte[] domainImageData = payment.getImageData();
        if ( domainImageData != null ) {
            paymentDomain.setDomainImageData( Arrays.copyOf( domainImageData, domainImageData.length ) );
        }
        paymentDomain.setDomainPaymentDate( payment.getPaymentDate() );
        paymentDomain.setDomainPaymentStatus( payment.isPaymentStatus() );

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
        byte[] imageData = paymentDomain.getDomainImageData();
        if ( imageData != null ) {
            payment.setImageData( Arrays.copyOf( imageData, imageData.length ) );
        }
        payment.setPaymentDate( paymentDomain.getDomainPaymentDate() );
        payment.setPaymentStatus( paymentDomain.isDomainPaymentStatus() );

        return payment;
    }
}
