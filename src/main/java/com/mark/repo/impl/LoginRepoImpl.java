package com.mark.repo.impl;

import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import com.mark.repo.ICustomerRepo;
import com.mark.repo.ILoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Repository
public class LoginRepoImpl implements ILoginRepo {

    @Autowired
    private ICustomerRepo iCustomerRepo;

    private static Map<String, String> veryUnsercuredCredentialSource = new HashMap<>();
    @Override
    public Customer login(LoginCredentials creds) {
        Customer customer = null;
        if ( creds != null && creds.getUserName() != null && creds.getPassword() != null)
        {
            String pass = veryUnsercuredCredentialSource.get(creds.getUserName());
            if ( creds.getPassword().equals(pass))
            {
                // get the customer associated with this username
                customer = iCustomerRepo.getCustomerForUserName(creds.getUserName());
            }
        }

        return customer;
    }

    static
    {
        veryUnsercuredCredentialSource.put("mark", "mark");
        veryUnsercuredCredentialSource.put("adriana", "adriana");
        veryUnsercuredCredentialSource.put("admin", "pass");
    }





}
