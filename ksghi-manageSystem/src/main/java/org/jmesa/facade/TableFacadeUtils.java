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
package org.jmesa.facade;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.jmesa.core.CoreContext;
import org.jmesa.limit.Limit;
import org.jmesa.limit.state.SessionState;
import org.jmesa.limit.state.State;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.editor.FilterEditor;
import org.jmesa.view.editor.HeaderEditor;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.renderer.*;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.WebContext;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetRow;
import org.jmesa.worksheet.editor.WorksheetEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utilities for the TableFacade.
 *
 * @author Jeff Johnston
 * @since 2.3
 */
public class TableFacadeUtils {
    public static final String TABLE_REFRESHING = "tr_";
    public static final String CLEARING_WORKSHEET = "cw_";
    private static final Logger logger = LoggerFactory.getLogger(TableFacadeUtils.class);

    private TableFacadeUtils() {
    }

    /**
     * Filter the items by the rows in the worksheet.
     *
     * @param items     The collection of beans or maps.
     * @param worksheet The current worksheet.
     * @return The filtered items.
     */
    static Collection<?> filterWorksheetItems(Collection<?> items, Worksheet worksheet) {
        if (!worksheet.isFiltering()) {
            return items;
        }

        Collection<WorksheetRow> worksheetRows = worksheet.getRows();

        if (items.size() == worksheetRows.size()) {
            return items;
        }

        List<Object> results = new ArrayList<Object>();

        for (Object item : items) {
            for (WorksheetRow worksheetRow : worksheetRows) {
                String uniqueProperty = worksheetRow.getUniqueProperty().getName();
                String uniquePropertyValue = worksheetRow.getUniqueProperty().getValue();
                try {
                    Object value = PropertyUtils.getProperty(item, uniqueProperty);
                    if (value.toString().equals(uniquePropertyValue)) {
                        results.add(item);
                    }

                } catch (Exception e) {
                    logger.error("Had problems evaluating the items.", e);
                }
            }
        }

        return results;
    }

    private static void init(Object obj, WebContext webContext, CoreContext coreContext) {
        SupportUtils.setWebContext(obj, webContext);
        SupportUtils.setCoreContext(obj, coreContext);
    }

    /**
     * Spin through the components and inject the proper support classes. This
     * is kind of a mini IOC implementation.
     */
    public static void initTable(TableFacade tableFacade, Table table) {
        WebContext webContext = tableFacade.getWebContext();
        CoreContext coreContext = tableFacade.getCoreContext();

        // get the table set up

        init(table, webContext, coreContext);

        TableRenderer tableRenderer = table.getTableRenderer();
        init(tableRenderer, webContext, coreContext);

        // get the row set up

        Row row = table.getRow();
        init(row, webContext, coreContext);

        if (row instanceof HtmlRow) {
            HtmlRow htmlRow = (HtmlRow) row;
            init(htmlRow.getOnclick(), webContext, coreContext);
            init(htmlRow.getOnmouseover(), webContext, coreContext);
            init(htmlRow.getOnmouseout(), webContext, coreContext);
        }

        RowRenderer rowRenderer = row.getRowRenderer();
        init(rowRenderer, webContext, coreContext);

        // get the column set up

        for (Column column : row.getColumns()) {
            init(column, webContext, coreContext);

            // cell

            CellRenderer cellRenderer = column.getCellRenderer();
            init(cellRenderer, webContext, coreContext);
            SupportUtils.setColumn(cellRenderer, column);

            CellEditor cellEditor = column.getCellEditor();
            init(cellEditor, webContext, coreContext);
            SupportUtils.setColumn(cellEditor, column);

            // header

            HeaderRenderer headerRenderer = column.getHeaderRenderer();
            init(headerRenderer, webContext, coreContext);
            SupportUtils.setColumn(headerRenderer, column);

            HeaderEditor headerEditor = column.getHeaderEditor();
            init(headerEditor, webContext, coreContext);
            SupportUtils.setColumn(headerEditor, column);

            // filter

            if (column instanceof HtmlColumn) {
                HtmlColumn htmlColumn = (HtmlColumn) column;

                WorksheetEditor worksheetEditor = htmlColumn.getWorksheetEditor();
                if (worksheetEditor != null) {
                    init(worksheetEditor, webContext, coreContext);
                    SupportUtils.setColumn(worksheetEditor, column);

                    CellEditor worksheetCellEditor = worksheetEditor.getCellEditor();
                    init(worksheetCellEditor, webContext, coreContext);
                    SupportUtils.setColumn(worksheetCellEditor, column);
                }

                FilterRenderer filterRenderer = htmlColumn.getFilterRenderer();
                init(filterRenderer, webContext, coreContext);
                SupportUtils.setColumn(filterRenderer, column);

                FilterEditor filterEditor = column.getFilterEditor();
                init(filterEditor, webContext, coreContext);
                SupportUtils.setColumn(filterEditor, column);
            }
        }
    }

    /**
     * @param id         The table identifier.
     * @param webContext The web context.
     * @return Is true if the user is requesting to clear all the worksheet
     * changes.
     */
    static boolean isClearingWorksheet(String id, WebContext webContext) {
        String clearingWorksheet = webContext.getParameter(id + "_" + CLEARING_WORKSHEET);
        if (StringUtils.isNotEmpty(clearingWorksheet) && clearingWorksheet.equals("true")) {
            return true;
        }

        return false;
    }

    /**
     * There needs to be a way to tell if the table is refreshing, as opposed to
     * being run for the first time.
     *
     * @param id         The table identifier.
     * @param webContext The web context.
     * @return Is true if the table is being refreshed.
     */
    static boolean isTableRefreshing(String id, WebContext webContext) {
        String refreshing = webContext.getParameter(id + "_" + TABLE_REFRESHING);
        if (StringUtils.isNotEmpty(refreshing) && refreshing.equals("true")) {
            return true;
        }

        return false;
    }

    /**
     * Retrieve the Limit from the State implemenation.
     *
     * @param id        The table identifier.
     * @param stateAttr The attribute used to retrieve the Limit.
     * @param request   The servlet request.
     * @return The Limit stored by the State implementation.
     * @deprecated This method is not used in the core api and will be removed.
     */
    @Deprecated
    public static Limit retrieveLimit(String id, String stateAttr, HttpServletRequest request) {
        WebContext webContext = new HttpServletRequestWebContext(request);
        State state = new SessionState();
        SupportUtils.setId(state, id);
        SupportUtils.setStateAttr(state, stateAttr);
        SupportUtils.setWebContext(state, webContext);
        return state.retrieveLimit();
    }
}
