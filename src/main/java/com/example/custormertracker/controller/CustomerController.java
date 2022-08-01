package com.example.custormertracker.controller;

import com.example.custormertracker.dao.CustomerDAO;
import com.example.custormertracker.entity.Customer;
import com.example.custormertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }
    //6. Update Customer - Save Customer to Database - Part 1


    //need to inject the dao to controller
    // spring finds the implementations of the class and inject it
    @Autowired
    private CustomerService customerService;

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomer(Model model) {
        //get customer from the dao
        List<Customer> theCustomers = customerService.getCustomers();
        // add the customers to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        //create model attribute to bind form data
        Customer theCustomer = new Customer();

        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        //save the customer using our service
        customerService.addCustomer(theCustomer);


    return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")

    public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel) {
        //get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);
        //set customer as a model attribute to pre-populate the form
         theModel.addAttribute("customer",theCustomer);

        //send over to our form

        return  "customer-form";
    }

    @GetMapping("/DeleteCustomer")
    public String DeleteCustomer(@RequestParam("customerId") int theId){
        //get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);
        customerService.DeleteCustomer(theCustomer);

        return "redirect:/customer/list";
    }

}












