package com.relatospapel.bookspayments.service.impl;

import com.relatospapel.bookspayments.dto.OrderDto;
import com.relatospapel.bookspayments.entity.OrderEntity;
import com.relatospapel.bookspayments.mapper.Mapper;
import com.relatospapel.bookspayments.repository.OrderRepository;
import com.relatospapel.bookspayments.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public OrderDto addOrder(OrderDto orderDto) {

        if(orderDto == null){
            throw new NullPointerException("El pedido DTO no debe ser null");
        }
        OrderEntity order = mapper.toOrderEntity(orderDto);
        log.info("Objeto entity creado : {}", order.getShippingAddress());
        OrderEntity saved = orderRepository.save(order);
        log.info("Pedido registrado. orderId={}, trackingCode={}, detalles={}",
                saved.getOrderId(), saved.getTrackingCode(), saved.getDetails().size());


        return orderDto;
    }

}
