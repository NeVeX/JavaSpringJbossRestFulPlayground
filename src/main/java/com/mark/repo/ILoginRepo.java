package com.mark.repo;

import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import org.springframework.stereotype.Repository;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Repository
public interface ILoginRepo {

    public Customer login(LoginCredentials creds);
}
