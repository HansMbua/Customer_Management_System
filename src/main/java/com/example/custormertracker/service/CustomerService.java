package com.example.custormertracker.service;

import com.example.custormertracker.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

    public Customer getCustomer(int theId);

    public void DeleteCustomer(Customer customer);

}
