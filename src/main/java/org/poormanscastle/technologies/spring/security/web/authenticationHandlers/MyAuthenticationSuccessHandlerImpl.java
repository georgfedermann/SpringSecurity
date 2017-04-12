package org.poormanscastle.technologies.spring.security.web.authenticationHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by georg on 12/04/2017.
 */
public class MyAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private final static Logger logger = Logger.getLogger(MyAuthenticationSuccessHandlerImpl.class);

    private final static boolean isInfo = logger.isInfoEnabled();

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (isInfo) {
            logger.info(StringUtils.join("Found UserDetails implementation ", authentication.getPrincipal().getClass().getCanonicalName()));
            logger.info(StringUtils.join("Beware! The user ", ((User) authentication.getPrincipal()).getUsername(), " just logged into the system."));
        }
    }
}
