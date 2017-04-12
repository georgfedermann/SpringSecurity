package org.poormanscastle.technologies.spring.security.web.authenticationHandlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * Created by georg on 12/04/2017.
 */
public class MyAuthenticationFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

    private final static Logger logger = Logger.getLogger(MyAuthenticationFailureHandlerImpl.class);

    private final static boolean isInfo = logger.isInfoEnabled();

    public MyAuthenticationFailureHandlerImpl(String failureUrl) {
        super(failureUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (isInfo) {
            logger.info(StringUtils.join("Beware! Authentication just failed for given principal ",
                    ((UsernamePasswordAuthenticationToken) e.getAuthentication()).getPrincipal(),
                    ". Additional information: ", e.getExtraInformation(), "; because: ", e.getMessage()));
        }
        super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
    }

}
