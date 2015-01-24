package com.mark.repo;

import com.mark.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mcunningham on 1/23/2015.
 */
@Repository
public interface ICustomerRepo {

    Customer getCustomer(int id);

    List<Customer> getCustomers(Customer input);

    List<Customer> getCustomers();
}
