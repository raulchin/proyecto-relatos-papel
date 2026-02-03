package com.relatospapel.bookspayments.service.impl;

import com.netflix.discovery.EurekaClient;
import com.relatospapel.bookspayments.repository.CatalogueRepository;
import com.relatospapel.bookspayments.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final CatalogueRepository catalogueRepository;

    private final EurekaClient eurekaClient;

    @Override
    public String savePayment(String name) {
        return "";
    }

    @Override
    public void deletePayment(String name) {

    }
}
