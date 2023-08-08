package com.allianz.example.service;

import com.allianz.example.database.repository.OrderEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderEntityService {

    private final OrderEntityRepository orderEntityRepository;

    public OrderEntityService(OrderEntityRepository orderEntityRepository) {
        this.orderEntityRepository = orderEntityRepository;
    }
}
