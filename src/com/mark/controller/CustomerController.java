package com.mark.controller;

import com.mark.dal.ICustomerDAL;
import com.mark.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mcunningham on 1/23/2015.
 */
@Controller
public class CustomerController {

    @Autowired
    private ICustomerDAL iCustomerDAL;

    @RequestMapping(value="/customers/all", method = RequestMethod.GET)
    public @ResponseBody List<Customer> getListOfCustomers()
    {
        System.out.println("GetCustomers invoked...");
        return iCustomerDAL.getCustomers();
    }

    @RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
    public @ResponseBody Customer getCustomerById(@PathVariable("id") int id)
    {
        System.out.println(String.format("GetCustomerById invoked...{0}", id));
        return iCustomerDAL.getCustomer(id);
    }

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public @ResponseBody List<Customer> getCustomerBySearch(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "age", required = false) Integer age)
    {
        Customer c = new Customer(null, firstName, lastName, age, null);
        System.out.println(String.format("GetCustomerBySearch invoked...{0}", c));
        return iCustomerDAL.getCustomers(c);
    }

}
