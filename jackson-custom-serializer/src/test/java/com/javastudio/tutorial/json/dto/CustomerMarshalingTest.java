package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CustomerMarshalingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerMarshalingTest.class);

    private static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @Test
    void serializeCustomer() throws JsonProcessingException {
        Customer customer = Customer.builder()
                .id(10)
                .name("Erik")
                .build();
        LOGGER.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer));
    }
}