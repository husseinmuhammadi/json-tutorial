package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductMarshalingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMarshalingTest.class);

    static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @Test
    void whenMarshalingProduct_thenItShouldContainsName() throws JsonProcessingException {
        Product product = new Product();
        product.setName("Nail");
        product.setWeight(10);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        LOGGER.info(json);
    }
}