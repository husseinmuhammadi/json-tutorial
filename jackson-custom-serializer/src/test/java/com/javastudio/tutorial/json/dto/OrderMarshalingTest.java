package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.javastudio.tutorial.json.dto.serializer.OrderSerializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class OrderMarshalingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerMarshalingTest.class);

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @Test
    void serializeOrderUsingJsonSerializeAnnotation() throws JsonProcessingException {
        Order order = Order.builder()
                .id(10)
                .orderDate(new Date())
                .customer(
                        Customer.builder()
                                .id(10)
                                .name("Erik")
                                .build()
                ).build();
        // This will use JsonSerialize annotation if it specifies
        LOGGER.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order));
    }

    @Test
    void serializeOrderWithCustomSerializer() throws JsonProcessingException {
        Order order = Order.builder()
                .id(10)
                .orderDate(new Date())
                .customer(
                        Customer.builder()
                                .id(10)
                                .name("Erik")
                                .build()
                ).build();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Order.class, new OrderSerializer());
        mapper.registerModule(module);
        LOGGER.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order));
    }
}