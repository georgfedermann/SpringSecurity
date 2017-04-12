package org.poormanscastle.technologies.spring.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by georg on 12/04/2017.
 */
@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, value = "/custom_login")
    public String showLoginForm() {
        return "login";
    }

}
