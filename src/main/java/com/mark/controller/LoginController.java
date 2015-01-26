package com.mark.controller;

import com.mark.dal.ILoginDAL;
import com.mark.model.Customer;
import com.mark.model.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mcunningham on 1/25/2015.
 */
@Controller
@SessionAttributes("customer")
public class LoginController {

    @Autowired
    private ILoginDAL iLoginDAL;

    @RequestMapping(value="/")
    public String checkLogin(Model model) {
        if ( model.containsAttribute("customer"))
        {
            return "home";
        }
        return "login";
    }

    @RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestBody(required = false) LoginCredentials creds, Model model) {
        System.out.println(String.format("Login invoked: {0}", creds));
        if ( creds != null) {
            Customer customer = iLoginDAL.login(creds);
            if (customer != null) {
                model.addAttribute("customer", customer);
                return "home";
            }
            throw new RuntimeException("Incorrect Login");
        }
        return "login";
    }
}
