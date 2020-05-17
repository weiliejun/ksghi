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

import java.io.Writer;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeff Johnston
 * @since 2.0
 */
public interface WebContext {
    public Object getApplicationAttribute(String name);

    public Object getApplicationInitParameter(String name);

    public Object getBackingObject();

    public String getContextPath();

    public Locale getLocale();

    public void setLocale(Locale locale);

    public Object getPageAttribute(String name);

    public String getParameter(String name);

    public Map<?, ?> getParameterMap();

    public void setParameterMap(Map<?, ?> parameterMap);

    public String getRealPath(String path);

    public Object getRequestAttribute(String name);

    public Object getSessionAttribute(String name);

    public Writer getWriter();

    public void removeApplicationAttribute(String name);

    public void removePageAttribute(String name);

    public void removeRequestAttribute(String name);

    public void removeSessionAttribute(String name);

    public void setApplicationAttribute(String name, Object value);

    public void setPageAttribute(String name, Object value);

    public void setRequestAttribute(String name, Object value);

    public void setSessionAttribute(String name, Object value);
}
