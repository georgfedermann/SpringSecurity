package org.poormanscastle.technologies.spring.security.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
            logger.info(StringUtils.join("Adding movie ", movie));
        }
        return "created";
    }

}
