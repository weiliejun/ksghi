/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeff Johnston
 * @since 2.0
 */
public class HttpServletRequestWebContext implements WebContext {
    private final HttpServletRequest request;
    private final ServletContext ctx;
    private Map<?, ?> parameterMap;
    private Locale locale;

    public HttpServletRequestWebContext(HttpServletRequest request) {
        this.request = request;
        this.ctx = request.getSession().getServletContext();
    }

    public HttpServletRequestWebContext(HttpServletRequest request, ServletContext ctx) {
        this.request = request;
        this.ctx = ctx;
    }

    public Object getApplicationAttribute(String name) {
        return ctx.getAttribute(name);
    }

    public Object getApplicationInitParameter(String name) {
        return ctx.getInitParameter(name);
    }

    public HttpServletRequest getBackingObject() {
        return request;
    }

    public String getContextPath() {
        return request.getContextPath();
    }

    protected HttpServletRequest getHttpServletRequest() {
        return request;
    }

    public Locale getLocale() {
        if (locale != null) {
            return locale;
        }

        return request.getLocale();
    }

    public void setLocale(Locale locale) {
        if (this.locale == null) {
            this.locale = locale;
        }
    }

    public Object getPageAttribute(String name) {
        return request.getAttribute(name);
    }

    public String getParameter(String name) {
        if (parameterMap != null) {
            String[] values = WebContextUtils.getValueAsArray(parameterMap.get(name));
            if (values != null && values.length > 0) {
                return values[0];
            }
        }

        return request.getParameter(name);
    }

    public Map<?, ?> getParameterMap() {
        if (parameterMap != null) {
            return parameterMap;
        }

        return request.getParameterMap();
    }

    public void setParameterMap(Map<?, ?> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public String getRealPath(String path) {
        return ctx.getRealPath(path);
    }

    public Object getRequestAttribute(String name) {
        return request.getAttribute(name);
    }

    public Object getSessionAttribute(String name) {
        return request.getSession().getAttribute(name);
    }

    public Writer getWriter() {
        return new StringWriter();
    }

    public void removeApplicationAttribute(String name) {
        ctx.removeAttribute(name);
    }

    public void removePageAttribute(String name) {
        request.removeAttribute(name);
    }

    public void removeRequestAttribute(String name) {
        request.removeAttribute(name);
    }

    public void removeSessionAttribute(String name) {
        request.getSession().removeAttribute(name);
    }

    public void setApplicationAttribute(String name, Object value) {
        ctx.setAttribute(name, value);
    }

    public void setPageAttribute(String name, Object value) {
        request.setAttribute(name, value);
    }

    public void setRequestAttribute(String name, Object value) {
        request.setAttribute(name, value);
    }

    public void setSessionAttribute(String name, Object value) {
        request.getSession().setAttribute(name, value);
    }
}
