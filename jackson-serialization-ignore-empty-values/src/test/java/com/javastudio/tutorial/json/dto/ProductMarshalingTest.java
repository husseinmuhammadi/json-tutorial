package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProductMarshalingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMarshalingTest.class);

    static ObjectMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @Test
    void whenMarshalingProduct_thenIgnoreEmptyValues() throws JsonProcessingException {
        Product product = new Product();
        product.setName("");
        product.setWeight(10);
        // String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        String json = mapper.writeValueAsString(product);
        LOGGER.info(json);
        Assertions.assertThat(json).doesNotContainPattern("name");
    }

    @Test
    void whenMarshalingProduct_thenIgnoreNullValues() throws JsonProcessingException {
        Product product = new Product();
        product.setWeight(10);
        // String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        String json = mapper.writeValueAsString(product);
        LOGGER.info(json);
        Assertions.assertThat(json).doesNotContainPattern("name");
    }
}