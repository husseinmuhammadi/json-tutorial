package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.javastudio.tutorial.json.dto.deserializer.OrderDeserializer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

class OrderUnmarshallingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderUnmarshallingTest.class);

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @Test
    void deserializeOrderWithCustomSerializer() throws JsonProcessingException {
        Order order = Order.builder()
                .id(10)
                .orderDate(new Date())
                .customer(
                        Customer.builder()
                                .id(10)
                                .name("Erik")
                                .build()
                ).build();
        String json = mapper.writeValueAsString(order);
        LOGGER.info(json);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Order.class, new OrderDeserializer());
        mapper.registerModule(module);

        Order order1 = mapper.readValue(json, Order.class);
        String json1 = mapper.writeValueAsString(order1);
        LOGGER.info(json1);
        Assertions.assertThat(json1).contains("id").contains("name");
    }
}
