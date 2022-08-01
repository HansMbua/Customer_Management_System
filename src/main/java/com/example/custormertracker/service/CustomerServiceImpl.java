package com.example.custormertracker.service;

import com.example.custormertracker.dao.CustomerDAO;
import com.example.custormertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    //inject the coustomerDAO
    @Autowired
    private CustomerDAO customerDAO;


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void DeleteCustomer(Customer customer) {
        customerDAO.DeleteCustomer(customer);
    }
}
