package com.boutique.momentos.domain.domainrepository;

import java.util.List;
import java.util.Optional;

import com.boutique.momentos.domain.domainentity.PaymentDomain;

public interface PaymentDomainRepository {
    List<PaymentDomain> getAll();
    PaymentDomain savePayment (PaymentDomain paymentDomain);
    Optional<List<PaymentDomain>> getByUser(Integer domainIdUser);
    Optional<PaymentDomain> getPayment(int domainIdPayment);
    void deletePayment(int domainIdPayment);
}
