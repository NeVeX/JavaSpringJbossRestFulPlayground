package com.mark.dal.impl;

import com.mark.dal.ILoginDAL;
import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import com.mark.repo.ILoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Repository
public class LoginDALImpl implements ILoginDAL {

    @Autowired
    private ILoginRepo iLoginRepo;

    @Override
    public Customer login(LoginCredentials creds) {
        return iLoginRepo.login(creds);
    }
}
