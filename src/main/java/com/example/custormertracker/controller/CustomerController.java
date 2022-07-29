package com.example.custormertracker.controller;

import com.example.custormertracker.dao.CustomerDAO;
import com.example.custormertracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the dao to controller
//spring finds the implementations of the class and inject it
    @Autowired
    private CustomerDAO customerDAO;



    @RequestMapping("/list")
    public String listCustomer(Model model) {
         //get customer from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();
        // add the customers to the model
        model.addAttribute("customers",theCustomers);

        return "list-customers";

    }
}
