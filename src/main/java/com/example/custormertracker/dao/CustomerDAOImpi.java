package com.example.custormertracker.dao;

import com.example.custormertracker.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomerDAOImpi implements CustomerDAO{

    //need to inject my hibernate data dependency so my database can use it
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> theQuery = session.createQuery("from Customer",Customer.class);


        //get the list
        List<Customer> customers = theQuery.getResultList();

        //return the list that are retrieved


        return customers ;
    }
}
