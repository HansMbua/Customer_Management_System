package com.example.custormertracker.dao;

import com.example.custormertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
    public void addCustomer(Customer customer);


   public Customer getCustomer(int theId);

   public void DeleteCustomer(Customer customer);
}
