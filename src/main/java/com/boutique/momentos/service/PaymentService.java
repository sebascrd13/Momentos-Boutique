package com.boutique.momentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.domain.domainrepository.PaymentDomainRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentDomainRepository paymentDomainRepository;

    public List<PaymentDomain> getAll(){
        return paymentDomainRepository.getAll();
    }
    public PaymentDomain savePayment(PaymentDomain paymentDomain){
        return paymentDomainRepository.savePayment(paymentDomain);
    }

    public Optional<List<PaymentDomain>> getByUser(int domainIdUser){
        return paymentDomainRepository.getByUser(domainIdUser);
    }

    public Optional<PaymentDomain> getPayment(int domainIdPayment){
        return paymentDomainRepository.getPayment(domainIdPayment);
    }

    public boolean delete(int domainIdPayment){
        if (getPayment(domainIdPayment).isPresent()){
            paymentDomainRepository.deletePayment(domainIdPayment);
            return true;
        } else {
            return false;
        }
    }
}
