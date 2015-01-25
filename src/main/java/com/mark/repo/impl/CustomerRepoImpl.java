package com.mark.repo.impl;

import com.mark.model.Customer;
import com.mark.repo.ICustomerRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by mcunningham on 1/23/2015.
 */
@Repository
public class CustomerRepoImpl implements ICustomerRepo {
    @Override
    public Customer getCustomer(int id) {
        Customer cc = customerList.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        return cc;
    }

    @Override
    public List<Customer> getCustomers(Customer input) {
        List<Customer> cust = new ArrayList<>();
        if (input != null )
        {
            cust = customerList.stream().filter(findMatchingCustomer(input)).collect(Collectors.toList());
        }
        return cust;
    }


    private Predicate<Customer> findMatchingCustomer(Customer input)
    {
        return c ->
                (input.getId() == null || input.getId() == c.getId())
                && (input.getFirstName() == null || String.CASE_INSENSITIVE_ORDER.compare(input.getFirstName(), c.getFirstName()) == 0)
                && (input.getLastName() == null || String.CASE_INSENSITIVE_ORDER.compare(input.getLastName(), c.getLastName()) == 0)
                && (input.getAge() == null || input.getAge() == c.getAge());
    }

    @Override
    public List<Customer> getCustomers() {
        return customerList;
    }


    private static List<Customer> customerList = new ArrayList<Customer>();

    static
    {
        customerList.add( new Customer(1, "Mark", "Cunningham", 28, null));
        customerList.add( new Customer(2, "John", "Smith", 23, null));
        customerList.add( new Customer(3, "Sharon", "Flaherty", 58, null));
        customerList.add( new Customer(4, "Caitriona", "Jones", 18, null));
        customerList.add( new Customer(5, "Eileen", "Clancy", 44, null));
        customerList.add( new Customer(6, "Frank", "Alcorta", 22, null));
        customerList.add( new Customer(7, "Mark", "Finnegan", 30, null));
        customerList.add( new Customer(8, "NeVeX", "Computing", 28, null));
    }


}
