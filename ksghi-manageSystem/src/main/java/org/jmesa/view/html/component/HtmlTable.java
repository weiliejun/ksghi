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
package org.jmesa.view.html.component;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.component.Table;
import org.jmesa.view.html.HtmlConstants;
import org.jmesa.view.html.renderer.HtmlTableRenderer;
import org.jmesa.view.renderer.TableRenderer;

/**
 * @author Jeff Johnston
 * @since 2.0
 */
public class HtmlTable extends Table {
    private String theme;
    private String style;
    private String styleClass;
    private String border;
    private String cellpadding;
    private String cellspacing;
    private String width;

    public HtmlTable border(String border) {
        setBorder(border);
        return this;
    }

    @Override
    public HtmlTable caption(String caption) {
        setCaption(caption);
        return this;
    }

    @Override
    public HtmlTable captionKey(String key) {
        setCaptionKey(key);
        return this;
    }

    public HtmlTable cellpadding(String cellpadding) {
        setCellpadding(cellpadding);
        return this;
    }

    public HtmlTable cellspacing(String cellspacing) {
        setCellspacing(cellspacing);
        return this;
    }

    public String getBorder() {
        if (StringUtils.isBlank(border)) {
            return "0";
        }

        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getCellpadding() {
        if (StringUtils.isBlank(cellpadding)) {
            return "0";
        }

        return cellpadding;
    }

    public void setCellpadding(String cellpadding) {
        this.cellpadding = cellpadding;
    }

    public String getCellspacing() {
        if (StringUtils.isBlank(cellspacing)) {
            return "0";
        }

        return cellspacing;
    }

    public void setCellspacing(String cellspacing) {
        this.cellspacing = cellspacing;
    }

    @Override
    public HtmlRow getRow() {
        return (HtmlRow) super.getRow();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        if (StringUtils.isBlank(styleClass)) {
            return getCoreContext().getPreference(HtmlConstants.TABLE_RENDERER_STYLE_CLASS);
        }

        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public HtmlTableRenderer getTableRenderer() {
        TableRenderer tableRenderer = super.getTableRenderer();
        if (tableRenderer == null) {
            HtmlTableRenderer htmlTableRenderer = new HtmlTableRenderer(this);
            super.setTableRenderer(htmlTableRenderer);
            return htmlTableRenderer;
        }
        return (HtmlTableRenderer) tableRenderer;
    }

    public String getTheme() {
        if (StringUtils.isBlank(theme)) {
            return getCoreContext().getPreference(HtmlConstants.TABLE_COMPONENT_THEME);
        }

        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public HtmlTable style(String style) {
        setStyle(style);
        return this;
    }

    public HtmlTable styleClass(String styleClass) {
        setStyleClass(styleClass);
        return this;
    }

    public HtmlTable theme(String theme) {
        setTheme(theme);
        return this;
    }

    public HtmlTable width(String width) {
        setWidth(width);
        return this;
    }
}
