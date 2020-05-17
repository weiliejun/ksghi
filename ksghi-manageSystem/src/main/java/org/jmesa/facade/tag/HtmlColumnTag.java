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
package org.jmesa.facade.tag;

import org.jmesa.util.ItemUtils;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.editor.FilterEditor;
import org.jmesa.view.editor.HeaderEditor;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.renderer.HtmlCellRenderer;
import org.jmesa.view.html.renderer.HtmlFilterRenderer;
import org.jmesa.view.html.renderer.HtmlHeaderRenderer;
import org.jmesa.worksheet.WorksheetValidation;
import org.jmesa.worksheet.editor.WorksheetEditor;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import static org.jmesa.facade.tag.TagUtils.*;

/**
 * Represents an HtmlColumn.
 *
 * @author jeff jie
 * @since 2.1
 */
public class HtmlColumnTag extends SimpleTagSupport {
    private String property;
    private String title;
    private String titleKey;
    private Boolean sortable;
    private String sortOrder;
    private Boolean filterable;
    private Boolean editable;
    private String worksheetEditor;
    private String width;
    private String cellRenderer;
    private String filterRenderer;
    private String headerRenderer;
    private String style;
    private String styleClass;
    private String filterStyle;
    private String filterClass;
    private String headerStyle;
    private String headerClass;
    private String pattern;
    private String cellEditor;
    private String headerEditor;
    private String filterEditor;
    private String worksheetValidation;
    private String customWorksheetValidation;
    private String errorMessageKey;
    private String errorMessage;

    @Override
    public void doTag() throws JspException, IOException {
        TableFacadeTag facadeTag = (TableFacadeTag) findAncestorWithClass(this, TableFacadeTag.class);
        Collection<Map<String, Object>> pageItems = facadeTag.getPageItems();
        if (pageItems.size() == 1) {
            HtmlRow row = facadeTag.getTable().getRow();
            HtmlComponentFactory factory = facadeTag.getComponentFactory();
            HtmlColumn column = getColumn(factory);
            TagUtils.validateColumn(this, getProperty());
            row.addColumn(column);
        }

        HtmlRowTag rowTag = (HtmlRowTag) findAncestorWithClass(this, HtmlRowTag.class);
        Map<String, Object> pageItem = rowTag.getPageItem();
        pageItem.put(getProperty(), getValue());
    }

    public String getCellEditor() {
        return cellEditor;
    }

    public void setCellEditor(String cellEditor) {
        this.cellEditor = cellEditor;
    }

    /**
     * @since 2.2
     */
    public String getCellRenderer() {
        return cellRenderer;
    }

    /**
     * @since 2.2
     */
    public void setCellRenderer(String cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    /**
     * The column to use. If the column does not exist then one will be created.
     */
    private HtmlColumn getColumn(HtmlComponentFactory factory) {
        HtmlColumn column = factory.createColumn(getProperty());
        column.setTitle(getTitle());
        column.setTitleKey(getTitleKey());
        column.setSortable(isSortable());
        column.setSortOrder(getColumnSortOrder(getSortOrder()));
        column.setFilterable(isFilterable());
        column.setEditable(isEditable());
        column.setWidth(getWidth());

        HtmlCellRenderer cr = getColumnCellRenderer(column, getCellRenderer());
        cr.setStyle(getStyle());
        cr.setStyleClass(getStyleClass());
        column.setCellRenderer(cr);

        // worksheet

        WorksheetEditor we = getColumnWorksheetEditor(column, getWorksheetEditor());
        cr.setWorksheetEditor(we);

        // cell

        CellEditor ce = getColumnCellEditor(column, getCellEditor(), getPattern(), getJspBody() != null);
        cr.setCellEditor(ce);

        // filter

        HtmlFilterRenderer fr = getColumnFilterRenderer(column, getFilterRenderer());
        fr.setStyle(getFilterStyle());
        fr.setStyleClass(getFilterClass());
        column.setFilterRenderer(fr);

        FilterEditor fe = getColumnFilterEditor(column, getFilterEditor());
        fr.setFilterEditor(fe);

        // header

        HtmlHeaderRenderer hr = getColumnHeaderRenderer(column, getHeaderRenderer());
        hr.setStyle(getHeaderStyle());
        hr.setStyleClass(getHeaderClass());
        column.setHeaderRenderer(hr);

        HeaderEditor he = getColumnHeaderEditor(column, getHeaderEditor());
        hr.setHeaderEditor(he);

        for (WorksheetValidation wsv : getWorksheetValidations(column, getWorksheetValidation(), getErrorMessageKey(), getErrorMessage(), false)) {
            column.addWorksheetValidation(wsv);
        }
        for (WorksheetValidation wsv : getWorksheetValidations(column, getCustomWorksheetValidation(), getErrorMessageKey(), getErrorMessage(), true)) {
            column.addWorksheetValidation(wsv);
        }

        return column;
    }

    /**
     * @since 2.6.7
     */
    public String getCustomWorksheetValidation() {
        return customWorksheetValidation;
    }

    /**
     * @param customWorksheetValidation The custom worksheet validation to use.
     * @since 2.6.7
     */
    public void setCustomWorksheetValidation(String customWorksheetValidation) {
        this.customWorksheetValidation = customWorksheetValidation;
    }

    /**
     * @since 2.6.7
     */

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage Error message for worksheet validation.
     * @since 2.6.7
     */

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @since 2.6.7
     */

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    /**
     * @param errorMessageKey Error message key for worksheet validation.
     * @since 2.6.7
     */

    public void setErrorMessageKey(String errorMessageKey) {
        this.errorMessageKey = errorMessageKey;
    }

    /**
     * @since 2.2
     */
    public String getFilterClass() {
        return filterClass;
    }

    /**
     * @since 2.2
     */
    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    /**
     * @return The filter editor for the column.
     * @since 2.2
     */
    public String getFilterEditor() {
        return filterEditor;
    }

    /**
     * @param filterEditor The filter editor to use.
     * @since 2.2
     */
    public void setFilterEditor(String filterEditor) {
        this.filterEditor = filterEditor;
    }

    /**
     * @since 2.2
     */
    public String getFilterRenderer() {
        return filterRenderer;
    }

    /**
     * @since 2.2
     */
    public void setFilterRenderer(String filterRenderer) {
        this.filterRenderer = filterRenderer;
    }

    /**
     * @since 2.2
     */
    public String getFilterStyle() {
        return filterStyle;
    }

    /**
     * @since 2.2
     */
    public void setFilterStyle(String filterStyle) {
        this.filterStyle = filterStyle;
    }

    /**
     * @since 2.2
     */
    public String getHeaderClass() {
        return headerClass;
    }

    /**
     * @since 2.2
     */
    public void setHeaderClass(String headerClass) {
        this.headerClass = headerClass;
    }

    /**
     * @return The header editor for the column.
     * @since 2.2
     */
    public String getHeaderEditor() {
        return headerEditor;
    }

    /**
     * @param headerEditor The header editor to use.
     * @since 2.2
     */
    public void setHeaderEditor(String headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * @since 2.2
     */
    public String getHeaderRenderer() {
        return headerRenderer;
    }

    /**
     * @since 2.2
     */
    public void setHeaderRenderer(String headerRenderer) {
        this.headerRenderer = headerRenderer;
    }

    /**
     * @since 2.2
     */
    public String getHeaderStyle() {
        return headerStyle;
    }

    /**
     * @since 2.2
     */
    public void setHeaderStyle(String headerStyle) {
        this.headerStyle = headerStyle;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return The sort order for the column.
     * @since 2.2
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder The order array.
     * @since 2.2
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @since 2.2.1
     */
    public String getStyle() {
        return style;
    }

    /**
     * @since 2.2.1
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @since 2.2.1
     */
    public String getStyleClass() {
        return styleClass;
    }

    /**
     * @since 2.2.1
     */
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    /**
     * If a ColumnTag body is defined then use it as the current page item
     * value. If it is not defined then get the page item value from the regular
     * bean by using the property
     *
     * @return The item to use.
     */
    private Object getValue() throws JspException, IOException {
        TableFacadeTag facadeTag = (TableFacadeTag) findAncestorWithClass(this, TableFacadeTag.class);
        String var = facadeTag.getVar();
        Object item = getJspContext().getAttribute(var);

        if (item == null) {
            return null;
        }

        JspFragment body = getJspBody();
        if (body == null) {
            return ItemUtils.getItemValue(item, getProperty());
        }

        StringWriter value = new StringWriter();
        body.invoke(value);
        return value;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWorksheetEditor() {
        return worksheetEditor;
    }

    public void setWorksheetEditor(String worksheetEditor) {
        this.worksheetEditor = worksheetEditor;
    }

    /**
     * @since 2.6.7
     */
    public String getWorksheetValidation() {
        return worksheetValidation;
    }

    /**
     * @param worksheetValidation The worksheet validation to use.
     * @since 2.6.7
     */
    public void setWorksheetValidation(String worksheetValidation) {
        this.worksheetValidation = worksheetValidation;
    }

    /**
     * @since 2.3
     */
    public Boolean isEditable() {
        return editable;
    }

    public Boolean isFilterable() {
        return filterable;
    }

    public Boolean isSortable() {
        return sortable;
    }

    /**
     * @since 2.3
     */
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public void setFilterable(Boolean filterable) {
        this.filterable = filterable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }
}
