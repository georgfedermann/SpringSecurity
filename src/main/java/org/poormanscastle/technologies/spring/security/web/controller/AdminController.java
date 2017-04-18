package org.poormanscastle.technologies.spring.security.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.poormanscastle.technologies.spring.security.domain.MyUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by georg on 11/04/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    public final static Logger logger = Logger.getLogger(AdminController.class);
    private final static boolean isInfo = logger.isInfoEnabled();

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    @ResponseBody
    public String createMovie(@RequestBody String movie) {
        if (AdminController.isInfo) {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.info(StringUtils.join("User ", user.getUsername(), " is adding movie ", movie));
        }
        return "created";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    @ResponseBody
    public String createMovie() {
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (AdminController.isInfo) {
            logger.info(StringUtils.join("Warning! User ", user, " is accessing movie x."));
        }
        return StringUtils.join("User ", user.getLastname(), " is accessing movie x.");
    }

}
