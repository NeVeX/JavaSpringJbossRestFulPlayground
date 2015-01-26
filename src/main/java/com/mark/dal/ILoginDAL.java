package com.mark.dal;

import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import org.springframework.stereotype.Repository;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Repository
public interface ILoginDAL {

    public Customer login(LoginCredentials creds);
}
