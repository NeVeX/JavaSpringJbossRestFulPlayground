package com.mark.controller;

import com.mark.dal.ILoginDAL;
import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginDAL iLoginDAL;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginCredentials creds, Model model) {
        System.out.println(String.format("Login invoked: {0}", creds));
        Customer customer = iLoginDAL.login(creds);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "home";
        }
        throw new RuntimeException("Incorrect Login");
    }
}
