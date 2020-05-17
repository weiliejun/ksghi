package com.itech.ups.base.web.servlet;

import com.itech.ups.base.ApplicationConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-8-12
 * @author  Jack Chen
 * ===========================================================================
 *
 */
abstract public class AbstractBaseServlet extends HttpServlet {

    private static final long serialVersionUID = -278006138054414890L;

    private Class clazz = this.getClass();

    private String methodParameterKey = "method";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeMethod(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeMethod(request, response);

    }

    public void executeMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodName = request.getParameter(methodParameterKey);

        // Identify the method object to be dispatched to
        Method method = null;
        try {
            method = clazz.getMethod(methodName, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
            Object[] args = {request, response};
            method.invoke(this, args);

        } catch (Exception e) {
            throw new ServletException(e);

        }
    }

    protected void forward2Page(HttpServletRequest request, HttpServletResponse response, String pagePath) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(pagePath);
        rd.forward(request, response);
    }

    protected void saveError(HttpServletRequest request, String message) {

        if (message == null || "".equals(message)) {
            return;
        }
        // Save the messages we need
        request.setAttribute(ApplicationConstant.PLATFORM_MESSAGE_KEY, message);
    }
}
