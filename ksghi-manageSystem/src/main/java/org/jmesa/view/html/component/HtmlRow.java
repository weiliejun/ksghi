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
import org.jmesa.util.SupportUtils;
import org.jmesa.view.component.Row;
import org.jmesa.view.html.HtmlConstants;
import org.jmesa.view.html.event.MouseRowEvent;
import org.jmesa.view.html.event.RowEvent;
import org.jmesa.view.html.renderer.HtmlRowRenderer;
import org.jmesa.view.renderer.RowRenderer;

/**
 * @author Jeff Johnston
 * @since 2.0
 */
public class HtmlRow extends Row {
    private String style;
    private String styleClass;
    private String highlightStyle;
    private String highlightClass;
    private String evenClass;
    private String oddClass;
    private Boolean filterable;
    private Boolean sortable;
    private boolean highlighter = true;
    private RowEvent onclick;
    private RowEvent onmouseout;
    private RowEvent onmouseover;

    public HtmlRow filterable(Boolean filterable) {
        setFilterable(filterable);
        return this;
    }

    @Override
    public HtmlColumn getColumn(int index) {
        return (HtmlColumn) super.getColumn(index);
    }

    @Override
    public HtmlColumn getColumn(String property) {
        return (HtmlColumn) super.getColumn(property);
    }

    public String getEvenClass() {
        if (StringUtils.isBlank(evenClass)) {
            return getCoreContext().getPreference(HtmlConstants.ROW_RENDERER_EVEN_CLASS);
        }

        return evenClass;
    }

    public void setEvenClass(String evenClass) {
        this.evenClass = evenClass;
    }

    public String getHighlightClass() {
        if (StringUtils.isBlank(highlightClass)) {
            return getCoreContext().getPreference(HtmlConstants.ROW_RENDERER_HIGHLIGHT_CLASS);
        }

        return highlightClass;
    }

    public void setHighlightClass(String highlightClass) {
        this.highlightClass = highlightClass;
    }

    public String getHighlightStyle() {
        return highlightStyle;
    }

    public void setHighlightStyle(String highlightStyle) {
        this.highlightStyle = highlightStyle;
    }

    public String getOddClass() {
        if (StringUtils.isBlank(oddClass)) {
            return getCoreContext().getPreference(HtmlConstants.ROW_RENDERER_ODD_CLASS);
        }

        return oddClass;
    }

    public void setOddClass(String oddClass) {
        this.oddClass = oddClass;
    }

    public RowEvent getOnclick() {
        return onclick;
    }

    public void setOnclick(RowEvent onclick) {
        this.onclick = onclick;
        SupportUtils.setRow(onclick, this);
    }

    public RowEvent getOnmouseout() {
        if (onmouseout == null) {
            onmouseout = new MouseRowEvent();
            SupportUtils.setRow(onmouseout, this);
        }

        return onmouseout;
    }

    public void setOnmouseout(RowEvent onmouseout) {
        this.onmouseout = onmouseout;
        SupportUtils.setRow(onmouseout, this);
    }

    public RowEvent getOnmouseover() {
        if (onmouseover == null) {
            onmouseover = new MouseRowEvent();
            SupportUtils.setRow(onmouseover, this);
        }

        return onmouseover;
    }

    public void setOnmouseover(RowEvent onmouseover) {
        this.onmouseover = onmouseover;
        SupportUtils.setRow(onmouseover, this);
    }

    @Override
    public HtmlRowRenderer getRowRenderer() {
        RowRenderer rowRenderer = super.getRowRenderer();
        if (rowRenderer == null) {
            HtmlRowRenderer htmlRowRenderer = new HtmlRowRenderer(this);
            super.setRowRenderer(htmlRowRenderer);
            return htmlRowRenderer;
        }
        return (HtmlRowRenderer) rowRenderer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public HtmlRow highlighter(boolean highlighter) {
        setHighlighter(highlighter);
        return this;
    }

    public Boolean isFilterable() {
        return filterable;
    }

    public boolean isHighlighter() {
        return highlighter;
    }

    public void setHighlighter(boolean highlighter) {
        this.highlighter = highlighter;
    }

    public Boolean isSortable() {
        return sortable;
    }

    public HtmlRow onclick(RowEvent onclick) {
        setOnclick(onclick);
        return this;
    }

    public HtmlRow onmouseout(RowEvent onmouseout) {
        setOnmouseout(onmouseout);
        return this;
    }

    public HtmlRow onmouseover(RowEvent onmouseover) {
        setOnmouseover(onmouseover);
        return this;
    }

    public void setFilterable(Boolean filterable) {
        this.filterable = filterable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    public HtmlRow sortable(Boolean sortable) {
        setSortable(sortable);
        return this;
    }

    @Override
    public HtmlRow uniqueProperty(String uniqueProperty) {
        super.uniqueProperty(uniqueProperty);
        return this;
    }
}
