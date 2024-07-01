package com.boutique.momentos.persistence.datarepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boutique.momentos.persistence.entity.Payment;

public interface PaymentDataRepository extends CrudRepository<Payment, Integer> {
    List<Payment> findByIdUser(Integer domainIdUser);
}