package com.boutique.momentos.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boutique.momentos.domain.domainentity.PaymentDomain;
import com.boutique.momentos.domain.domainrepository.PaymentDomainRepository;
import com.boutique.momentos.persistence.datarepository.PaymentDataRepository;
import com.boutique.momentos.persistence.entity.Payment;
import com.boutique.momentos.persistence.mapper.PaymentMapper;

@Repository
public class PaymentRepository implements PaymentDomainRepository {

    @Autowired
    private PaymentDataRepository paymentDataRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<PaymentDomain> getAll() {
        List<Payment> payments = (List<Payment>) paymentDataRepository.findAll();
        return paymentMapper.toPaymentsDomain(payments);
    }

    @Override
    public PaymentDomain savePayment(PaymentDomain paymentDomain) {
        Payment payment = paymentMapper.toDomainPayment(paymentDomain);
        return paymentMapper.toPayment(paymentDataRepository.save(payment));
    }

    @Override
    public Optional<List<PaymentDomain>> getByUser(Integer domainIdUser) {
        List<Payment> payments = paymentDataRepository.findByIdUser(domainIdUser);
        return Optional.ofNullable(paymentMapper.toPaymentsDomain(payments));
    }

    @Override
    public Optional<PaymentDomain> getPayment(int domainIdPayment) {
        return paymentDataRepository.findById(domainIdPayment).map(payment -> paymentMapper.toPayment(payment));
    }

    @Override
    public void deletePayment(int domainIdPayment) {
        paymentDataRepository.deleteById(domainIdPayment);
    }
}
