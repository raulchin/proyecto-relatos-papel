package com.relatospapel.bookspayments.mapper;

import com.relatospapel.bookspayments.client.BooksCatalogueClient;
import com.relatospapel.bookspayments.dto.BookResponse;
import com.relatospapel.bookspayments.dto.OrderDetailDto;
import com.relatospapel.bookspayments.dto.OrderDto;
import com.relatospapel.bookspayments.entity.OrderDetailsEntity;
import com.relatospapel.bookspayments.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class Mapper {

    @Autowired
    BooksCatalogueClient booksCatalogueClient;

    public OrderEntity toOrderEntity(OrderDto dto){

        if(dto == null){
            throw new NullPointerException("El pedido DTO no debe ser null");
        }
        if (dto.details() == null || dto.details().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un detalle");
        }
        String uuid = UUID.randomUUID().toString();
        OrderEntity order = OrderEntity.builder()
                .clientId(dto.clientId())
                .orderDate(OffsetDateTime.now())
                .statusOrder(dto.statusOrder())
                .statusPayment(dto.statusPayment())
                .statusShipment(dto.statusShipment())
                .subtotal(dto.subtotal())
                .totalDiscount(dto.totalDiscount())
                .tax(dto.tax())
                .shippingCost(dto.shippingCost())
                .total(dto.total())
                .currency(dto.currency())
                .paymentMethod(dto.paymentMethod())
                .shippingAddress(dto.shippingAddress())
                .trackingCode(uuid)
                .build();
        for (OrderDetailDto detailDto : dto.details()){
            BookResponse bookResponse = booksCatalogueClient.findBookById(detailDto.bookId());
            if(bookResponse != null){
                BigDecimal lineSubtotal = bookResponse.price().multiply(BigDecimal.valueOf(detailDto.quantity()));
                OrderDetailsEntity detailsEntity = OrderDetailsEntity.builder()
                        .bookId(bookResponse.idBook())
                        .stock(detailDto.quantity())
                        .precioUnitario(bookResponse.price())
                        .subtotalLinea(lineSubtotal)
                        .build();
                order.addDetalle(detailsEntity);
            }

        }
        return order;
    }

}
