package com.javastudio.tutorial.json.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.javastudio.tutorial.json.dto.serializer.OrderSerializer;

import java.util.Date;

// @JsonSerialize(using = OrderSerializer.class)
public class Order {
    private final int id;
    private final Date orderDate;
    private final Customer customer;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        this.customer = builder.customer;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private int id;
        private Date orderDate;
        private Customer customer;

        public OrderBuilder id(int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public OrderBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Order build() {
            Order order = new Order(this);
            validteOrderObject(order);
            return order;
        }

        private void validteOrderObject(Order order) {

        }
    }
}
