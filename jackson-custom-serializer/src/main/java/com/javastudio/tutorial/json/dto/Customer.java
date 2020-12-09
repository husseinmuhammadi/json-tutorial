package com.javastudio.tutorial.json.dto;

public class Customer {
    private final int id;
    private final String name;

    private Customer(CustomerBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {
        private int id;
        private String name;

        private CustomerBuilder() {
        }

        public CustomerBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer(this);
            validateCustomer(customer);
            return customer;
        }

        private void validateCustomer(Customer customer) {

        }
    }
}
