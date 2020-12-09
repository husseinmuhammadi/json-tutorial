package com.javastudio.tutorial.json.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.javastudio.tutorial.json.dto.Order;

import java.io.IOException;

public class OrderSerializer extends StdSerializer<Order> {
    public OrderSerializer() {
        super(Order.class);
    }

    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", order.getId());
        jsonGenerator.writeEndObject();
    }
}
