package com.appress.pss.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by georg on 06/04/2017.
 */
@WebServlet(urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {

    public static final long serialVersionUID = 0L;

    private final static Logger logger = Logger.getLogger(HelloWorldServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.getWriter().write("Hello, world!");
        } catch (IOException exception) {
            logger.error(StringUtils.join("Cannot process HTTP request because: ", exception.getMessage()), exception);
        }
    }
}
