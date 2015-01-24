package com.mark.dal;

import com.mark.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mcunningham on 1/23/2015.
 */
@Repository
public interface ICustomerDAL {

    public Customer getCustomer(int id);

    public List<Customer> getCustomers();

    public List<Customer> getCustomers(Customer c);
}
