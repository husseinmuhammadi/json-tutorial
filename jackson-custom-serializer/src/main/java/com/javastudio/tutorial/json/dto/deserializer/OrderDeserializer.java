package com.javastudio.tutorial.json.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.javastudio.tutorial.json.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class OrderDeserializer extends StdDeserializer<Order> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDeserializer.class);

    public OrderDeserializer() {
        super(Order.class);
    }

    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Number id = node.get("id").numberValue();
        Number orderDate = node.get("orderDate").numberValue();
        return Order.builder().id(id.intValue()).orderDate(new Date(orderDate.longValue())).build();
    }
}
