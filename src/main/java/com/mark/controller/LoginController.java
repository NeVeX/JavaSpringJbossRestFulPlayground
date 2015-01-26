package com.mark.controller;

import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import org.springframework.stereotype.Controller;
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
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginCredentials creds)
    {
        System.out.println(String.format("Login invoked: {0}",creds));
        // validate the creds
        return "home";
    }
}
