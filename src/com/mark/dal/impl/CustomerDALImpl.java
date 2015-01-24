package com.mark.dal.impl;

import com.mark.dal.ICustomerDAL;
import com.mark.model.Customer;
import com.mark.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mcunningham on 1/23/2015.
 */
@Repository
public class CustomerDALImpl implements ICustomerDAL {

    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Customer getCustomer(int id) {
        return iCustomerRepo.getCustomer(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return iCustomerRepo.getCustomers();
    }

    @Override
    public List<Customer> getCustomers(Customer c) {
        return iCustomerRepo.getCustomers(c);
    }
}
