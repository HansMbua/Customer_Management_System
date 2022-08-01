package com.example.custormertracker.dao;

import com.example.custormertracker.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class CustomerDAOImpi implements CustomerDAO{

    //need to inject my hibernate data dependency so my database can use it
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> theQuery = session.createQuery("from Customer order by lastName",Customer.class);

//       Function<Customer, String> byFirstName = Customer::getFirstName;
//        Function<Customer, String> byLastName = Customer::getLastName;

        //get the list
        List<Customer> customers = theQuery.getResultList();
//        Comparator<Customer> comparator = Comparator.comparing(byLastName);
//        //return the list of sorted customers retrieved
//        customers.stream().sorted(comparator).collect(Collectors.toList());

        return customers;
    }

    @Override
    public void addCustomer(Customer thecustomer) {
        Session session = sessionFactory.getCurrentSession();

        //save or update the customer...
        session.saveOrUpdate(thecustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
       Session session = sessionFactory.getCurrentSession();
       Customer theCustomer = session.get(Customer.class,theId);

       return theCustomer;
    }

    @Override
    public void DeleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

//        Query theQuery = session.createQuery("delete from Customer where id=customerId");
//        theQuery.setParameter("customerId",theId);
//        theQuery.executeUpdate();

        session.delete(customer);

    }


}
