// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HtmlSnippets.java

package org.jmesa.view.html;

import org.apache.commons.lang.StringEscapeUtils;
import org.jmesa.core.CoreContext;
import org.jmesa.limit.Filter;
import org.jmesa.limit.Limit;
import org.jmesa.limit.RowSelect;
import org.jmesa.limit.Sort;
import org.jmesa.view.AbstractContextSupport;
import org.jmesa.view.ViewUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetRow;
import org.jmesa.worksheet.WorksheetRowStatus;
import org.jmesa.worksheet.WorksheetValidation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.jmesa.view.html:
//			HtmlBuilder, HtmlUtils

public class HtmlSnippets extends AbstractContextSupport {

    private HtmlTable table;
    private Toolbar toolbar;

    public HtmlSnippets(HtmlTable table, Toolbar toolbar, CoreContext coreContext) {
        this.table = table;
        this.toolbar = toolbar;
        setCoreContext(coreContext);
    }

    public String body() {
        HtmlBuilder html = new HtmlBuilder();
        CoreContext coreContext = getCoreContext();
        html.append(worksheetRowsAdded());
        int rowcount = HtmlUtils.startingRowcount(coreContext);
        Collection items = coreContext.getPageItems();
        for (Iterator iterator = items.iterator(); iterator.hasNext(); html.trEnd(1)) {
            Object item = iterator.next();
            rowcount++;
            HtmlRow row = table.getRow();
            List columns = row.getColumns();
            html.append(row.getRowRenderer().render(item, rowcount));
            HtmlColumn column;
            for (Iterator iter = columns.iterator(); iter.hasNext(); html.append(column.getCellRenderer().render(item, rowcount)))
                column = (HtmlColumn) iter.next();

        }

        return html.toString();
    }

    public String filter() {
        HtmlRow row = table.getRow();
        List columns = row.getColumns();
        if (!ViewUtils.isFilterable(columns))
            return "";
        HtmlBuilder html = new HtmlBuilder();
        String filterClass = getCoreContext().getPreference("html.filterClass");
        html.tr(1).styleClass(filterClass).close();
        for (Iterator iter = columns.iterator(); iter.hasNext(); ) {
            HtmlColumn column = (HtmlColumn) iter.next();
            if (column.isFilterable())
                html.append(column.getFilterRenderer().render());
            else
                html.td(2).close().tdEnd();
        }

        html.trEnd(1);
        return html.toString();
    }

    public String footer() {
        return null;
    }

    private String getCustomWorksheetValidations() {
        StringBuilder html = new StringBuilder();
        for (Iterator iterator = table.getRow().getColumns().iterator(); iterator.hasNext(); ) {
            Column column = (Column) iterator.next();
            HtmlColumn htmlColumn = (HtmlColumn) column;
            WorksheetValidation worksheetValidation;
            for (Iterator iterator1 = htmlColumn.getWorksheetValidations().iterator(); iterator1.hasNext(); html.append(worksheetValidation.getCustomWorksheetValidation()))
                worksheetValidation = (WorksheetValidation) iterator1.next();

        }

        return html.toString();
    }

    protected HtmlTable getHtmlTable() {
        return table;
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    private String getWorksheetValidation() {
        HtmlBuilder html = new HtmlBuilder();
        String rules = getWorksheetValidationRules();
        String messages = getWorksheetValidationMessages();
        String customValidations = getCustomWorksheetValidations();
        String limitId = getCoreContext().getLimit().getId();
        if (!"".equals(rules)) {
            html.tab().append((new StringBuilder("jQuery.jmesa.setValidator('")).append(limitId).append("', {").toString()).newline();
            html.tabs(2).append("rules: {");
            html.append(rules).newline();
            html.tabs(2).append("}");
            if (!"".equals(messages)) {
                html.append(",").newline();
                html.tabs(2).append("messages: {");
                html.append(messages).newline();
                html.tabs(2).append("}");
            }
            html.append(",").newline();
            html.tabs(2).append("showErrors: function(errorMap, errorList) {").newline();
            html.tabs(3).append("jQuery.jmesa.setError(errorMap);").newline();
            html.tabs(2).append("},").newline();
            html.tabs(2).append("onsubmit: false,").newline();
            html.tabs(2).append("onfocusout: false,").newline();
            html.tabs(2).append("onkeyup: false,").newline();
            html.tabs(2).append("onclick: false").newline();
            html.tab().append("});").newline();
            html.tab().append(customValidations);
        }
        return html.toString();
    }

    private String getWorksheetValidationMessages() {
        return prepareValidationJsonString("messages");
    }

    private String getWorksheetValidationRules() {
        return prepareValidationJsonString("rules");
    }

    public String header() {
        HtmlBuilder html = new HtmlBuilder();
        String headerClass = getCoreContext().getPreference("html.headerClass");
        html.tr(1).styleClass(headerClass).close();
        HtmlRow row = table.getRow();
        List columns = row.getColumns();
        HtmlColumn column;
        for (Iterator iter = columns.iterator(); iter.hasNext(); html.append(column.getHeaderRenderer().render()))
            column = (HtmlColumn) iter.next();

        html.trEnd(1);
        return html.toString();
    }

    public String initJavascriptLimit() {
        HtmlBuilder html = new HtmlBuilder();
        html.newline();
        html.script().type("text/javascript").close();
        html.newline();
        CoreContext coreContext = getCoreContext();
        Limit limit = coreContext.getLimit();
        boolean useDocumentReady = HtmlUtils.useDocumentReadyToInitJavascriptLimit(coreContext);
        if (useDocumentReady)
            html.append("jQuery(document).ready(function(){").newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.addTableFacade('")).append(limit.getId()).append("')").toString()).semicolon().newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.setMaxRowsToLimit('")).append(limit.getId()).append("','").append(limit.getRowSelect().getMaxRows()).append("')").toString()).semicolon().newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.setTotalRowsToLimit('")).append(limit.getId()).append("','").append(limit.getRowSelect().getTotalRows()).append("')").toString()).semicolon().newline();
        Sort sort;
        for (Iterator iterator = limit.getSortSet().getSorts().iterator(); iterator.hasNext(); html.tab().append((new StringBuilder("jQuery.jmesa.addSortToLimit('")).append(limit.getId()).append("','").append(sort.getPosition()).append("','").append(sort.getProperty()).append("','").append(sort.getOrder().toParam()).append("')").toString()).semicolon().newline())
            sort = (Sort) iterator.next();

        Filter filter;
        String value;
        for (Iterator iterator1 = limit.getFilterSet().getFilters().iterator(); iterator1.hasNext(); html.tab().append((new StringBuilder("jQuery.jmesa.addFilterToLimit('")).append(limit.getId()).append("','").append(filter.getProperty()).append("','").append(value).append("')").toString()).semicolon().newline()) {
            filter = (Filter) iterator1.next();
            value = StringEscapeUtils.escapeJavaScript(filter.getValue());
        }

        Worksheet worksheet = coreContext.getWorksheet();
        if (worksheet != null && worksheet.isFiltering())
            html.tab().append((new StringBuilder("jQuery.jmesa.setFilterToWorksheet('")).append(limit.getId()).append("')").toString()).semicolon().newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.setPageToLimit('")).append(limit.getId()).append("','").append(limit.getRowSelect().getPage()).append("')").toString()).semicolon().newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.setOnInvokeAction('")).append(limit.getId()).append("','").append(coreContext.getPreference("html.onInvokeAction")).append("')").toString()).semicolon().newline();
        html.tab().append((new StringBuilder("jQuery.jmesa.setOnInvokeExportAction('")).append(limit.getId()).append("','").append(coreContext.getPreference("html.onInvokeExportAction")).append("')").toString()).semicolon().newline();
        if (getWebContext() != null)
            html.tab().append((new StringBuilder("jQuery.jmesa.setContextPath('")).append(limit.getId()).append("','").append(StringEscapeUtils.escapeJavaScript(getWebContext().getContextPath())).append("')").toString()).semicolon().newline();
        html.append(getWorksheetValidation());
        if (useDocumentReady)
            html.append("});").newline();
        html.scriptEnd();
        return html.toString();
    }

    private String prepareValidationJsonString(String type) {
        HtmlBuilder json = new HtmlBuilder();
        boolean firstOccurance = true;
        for (Iterator iterator = table.getRow().getColumns().iterator(); iterator.hasNext(); ) {
            Column column = (Column) iterator.next();
            HtmlColumn htmlColumn = (HtmlColumn) column;
            String nameValuePair = null;
            if ("rules".equals(type))
                nameValuePair = htmlColumn.getWorksheetValidationRules();
            else if ("messages".equals(type))
                nameValuePair = htmlColumn.getWorksheetValidationMessages();
            if (!"".equals(nameValuePair)) {
                if (firstOccurance)
                    firstOccurance = false;
                else
                    json.append(",");
                json.newline().tabs(3).append(nameValuePair);
            }
        }

        return json.toString();
    }

    public String statusBar() {
        HtmlBuilder html = new HtmlBuilder();
        HtmlRow row = table.getRow();
        List columns = row.getColumns();
        html.tbody(1).close();
        String toolbarClass = getCoreContext().getPreference("html.statusBarClass");
        html.tr(1).styleClass(toolbarClass).close();
        html.td(2).align("left").colspan(String.valueOf(columns.size())).close();
        html.append(statusBarText());
        html.tdEnd();
        html.trEnd(1);
        html.tbodyEnd(1);
        return html.toString();
    }

    public String statusBarText() {
        CoreContext coreContext = getCoreContext();
        Limit limit = coreContext.getLimit();
        RowSelect rowSelect = limit.getRowSelect();
        if (rowSelect.getTotalRows() == 0) {
            return coreContext.getMessage("html.statusbar.noResultsFound");
        } else {
            Integer total = Integer.valueOf(rowSelect.getTotalRows());
            Integer from = Integer.valueOf(rowSelect.getRowStart() + 1);
            Integer to = Integer.valueOf(rowSelect.getRowEnd());
            Object[] messageArguments = {total, from, to};
            return coreContext.getMessage("html.statusbar.resultsFound", messageArguments);
        }
    }

    public String tableEnd() {
        HtmlBuilder html = new HtmlBuilder();
        html.tableEnd(0);
        return html.toString();
    }

    public String tableStart() {
        HtmlBuilder html = new HtmlBuilder();
        html.append(table.getTableRenderer().render());
        return html.toString();
    }

    public String tbodyEnd() {
        HtmlBuilder html = new HtmlBuilder();
        html.tbodyEnd(1);
        return html.toString();
    }

    public String tbodyStart() {
        HtmlBuilder html = new HtmlBuilder();
        String tbodyClass = getCoreContext().getPreference("html.tbodyClass");
        html.tbody(1).styleClass(tbodyClass).close();
        return html.toString();
    }

    public String theadEnd() {
        HtmlBuilder html = new HtmlBuilder();
        html.theadEnd(1);
        return html.toString();
    }

    public String theadStart() {
        HtmlBuilder html = new HtmlBuilder();
        html.thead(1).close();
        return html.toString();
    }

    public String themeEnd() {
        HtmlBuilder html = new HtmlBuilder();
        html.newline();
        html.divEnd();
        return html.toString();
    }

    public String themeStart() {
        HtmlBuilder html = new HtmlBuilder();
        html.div().styleClass(table.getTheme()).close();
        return html.toString();
    }

    public String toolbar() {
        HtmlBuilder html = new HtmlBuilder();
        HtmlRow row = table.getRow();
        List columns = row.getColumns();
        String toolbarClass = getCoreContext().getPreference("html.toolbarClass");
        html.tr(1).styleClass(toolbarClass).close();
        html.td(2).align("left").colspan(String.valueOf("3")).close();
        html.append(statusBarText());
        html.tdEnd();
        html.td(2).colspan(String.valueOf(columns.size() - 3)).close();
        html.append(toolbar.render());
        html.tdEnd();
        html.trEnd(1);
        return html.toString();
    }

    public String worksheetRowsAdded() {
        HtmlBuilder html = new HtmlBuilder();
        CoreContext coreContext = getCoreContext();
        Worksheet worksheet = coreContext.getWorksheet();
        if (worksheet == null)
            return "";
        List worksheetRows = worksheet.getRowsByStatus(WorksheetRowStatus.ADD);
        if (worksheetRows.isEmpty())
            return "";
        int rowcount = 0;
        for (Iterator iterator = worksheetRows.iterator(); iterator.hasNext(); html.trEnd(1)) {
            WorksheetRow worksheetRow = (WorksheetRow) iterator.next();
            Object item = worksheetRow.getItem();
            HtmlRow row = table.getRow();
            List columns = row.getColumns();
            html.append(row.getRowRenderer().render(item, --rowcount));
            HtmlColumn column;
            for (Iterator iter = columns.iterator(); iter.hasNext(); html.append(column.getCellRenderer().render(item, 0)))
                column = (HtmlColumn) iter.next();

        }

        html.append(worksheetRowsAddedHeader("", table.getRow().getColumns().size() + 1));
        return html.toString();
    }

    private String worksheetRowsAddedHeader(String title, int colspan) {
        HtmlBuilder html = new HtmlBuilder();
        html.tr(1).styleClass("addRow").close();
        html.td(2).colspan(String.valueOf(colspan)).close().append(title).tdEnd();
        html.trEnd(1);
        return html.toString();
    }
}
