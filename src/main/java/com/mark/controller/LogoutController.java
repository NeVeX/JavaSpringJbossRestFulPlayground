package com.mark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by mcunningham on 1/26/2015.
 */

@Controller
public class LogoutController {
    @RequestMapping(value="/logout")
    public String logout(HttpSession session)
    {
        System.out.println("logging out user...");
        session.invalidate();
        return "logout";
    }

}
