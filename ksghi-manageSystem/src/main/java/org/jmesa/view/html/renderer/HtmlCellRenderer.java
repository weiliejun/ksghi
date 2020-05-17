package org.jmesa.view.html.renderer;

import com.itech.core.util.EmailValidator;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.commons.lang.StringUtils;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.renderer.AbstractCellRenderer;
import org.jmesa.web.WebContext;
import org.jmesa.worksheet.editor.WorksheetEditor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class HtmlCellRenderer extends AbstractCellRenderer {
    static Properties prop = new Properties();

    static {

        InputStream is = HtmlCellRenderer.class.getResourceAsStream("/config/customerServiceStaff.properties");
        try {

            prop.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HtmlCellRenderer() {
    }

    public HtmlCellRenderer(HtmlColumn column) {
        setColumn(column);
    }

    /**
     * @deprecated Method HtmlCellRenderer is deprecated
     */

    public HtmlCellRenderer(HtmlColumn column, CellEditor editor) {
        setColumn(column);
        setCellEditor(editor);
    }

    public static void main(String[] args) {
        String a = "15011587886";
        String b = a.substring(3, a.length() - 4);
        a = a.replace(a.substring(3, a.length() - 4), "****");
        System.out.println(b);
        System.out.println(a);
    }

    /**
     * @deprecated Method getCellEditor is deprecated
     */

    public CellEditor getCellEditor() {
        return getColumn().getCellEditor();
    }

    /**
     * @deprecated Method setCellEditor is deprecated
     */

    public void setCellEditor(CellEditor cellEditor) {
        getColumn().setCellEditor(cellEditor);
    }

    public HtmlColumn getColumn() {
        return (HtmlColumn) super.getColumn();
    }

    protected String getId(int rowcount) {
        if (getCoreContext().getPreference("html.column.cell.renderer.includeId").equals("false")) {
            return null;
        } else {
            String id = (new StringBuilder(String.valueOf(getCoreContext().getLimit().getId()))).append("_column_").append(getColumn().getProperty()).append("_").append(rowcount).toString();
            id = id.replaceAll("\\.", "_");
            return id;
        }
    }

    /**
     * @deprecated Method getStyle is deprecated
     */

    public String getStyle() {
        return getColumn().getStyle();
    }

    /**
     * @deprecated Method setStyle is deprecated
     */

    public void setStyle(String style) {
        getColumn().setStyle(style);
    }

    /**
     * @deprecated Method getStyleClass is deprecated
     */

    public String getStyleClass() {
        return getColumn().getStyleClass();
    }

    /**
     * @deprecated Method setStyleClass is deprecated
     */

    public void setStyleClass(String styleClass) {
        getColumn().setStyleClass(styleClass);
    }

    /**
     * @deprecated Method getWorksheetEditor is deprecated
     */

    public WorksheetEditor getWorksheetEditor() {
        return getColumn().getWorksheetEditor();
    }

    /**
     * @deprecated Method setWorksheetEditor is deprecated
     */

    public void setWorksheetEditor(WorksheetEditor worksheetEditor) {
        getColumn().setWorksheetEditor(worksheetEditor);
    }

    public Object render(Object item, int rowcount) {
        WebContext context = getWebContext();
        HtmlBuilder html = new HtmlBuilder();
        html.td(2).id(getId(rowcount));
        html.width(getColumn().getWidth());
        html.style(getStyle());
        html.styleClass(getStyleClass());
        html.close();
        CurrentManager currentManager = (CurrentManager) context.getSessionAttribute("CURRENT_MANAGER");
        String roleName = "";
        List roles = null;
        Role role = null;
        if (currentManager != null) {
            roles = currentManager.getRoles();
            if (roles != null && roles.size() > 0) {
                for (int i = 0; i < roles.size(); i++) {
                    role = (Role) roles.get(i);
                    if (role.getName().equalsIgnoreCase("隐私保护") || role.getName().equalsIgnoreCase("身份证保护"))
                        roleName = role.getName();
                }

            }
        }
        String property = getColumn().getProperty();
        Object value = getCellEditor().getValue(item, property, rowcount);
        if (value != null && !"".equalsIgnoreCase(value.toString())) {
            if (property != null && !"".equalsIgnoreCase(property)) {
                property = property.toLowerCase().trim();
                if (property.equalsIgnoreCase("id_no")) {
                    String newValue = value.toString().trim();
                    if (StringUtils.isNotBlank(newValue) && !roleName.equalsIgnoreCase("身份证保护")) {
//                        value = newValue.substring(0, 3) + "***********" + newValue.substring(newValue.length() - 4, newValue.length());

                    }
                }
                if (StringUtils.isNotBlank(property) && (property.equalsIgnoreCase("mobile") || property.equalsIgnoreCase("user_mobile") || property.equalsIgnoreCase("receive_address") || property.equalsIgnoreCase("RECOMMENDER_MOBILE") || property.equalsIgnoreCase("RECOMMENDERMOBILE"))) {
                    String newValue = value.toString().trim();
                    if (StringUtils.isNotBlank(newValue) && !roleName.equalsIgnoreCase("隐私保护")) {
//                        value = newValue.substring(0, 3) + "****" + newValue.substring(newValue.length() - 4, newValue.length());

                    }

                    String cno_pwd = null;
                    try {
                        // Properties prop = new Properties();
                        // FileInputStream is = new
                        // FileInputStream(context.getRealPath("/") + "WEB-INF"
                        // + File.separator + "classes" + File.separator +
                        // "config" + File.separator +
                        // "customerServiceStaff.properties");
                        // System.out.println("===========" +
                        // context.getRealPath("/") + "WEB-INF" + File.separator
                        // + "classes" + File.separator + "config" +
                        // File.separator + "customerServiceStaff.properties");
                        // prop.load(is);
                        cno_pwd = prop.getProperty(currentManager.getManager().getCode());

                        // cno_pwd =
                        // ConstantTool.getCno_pwd(currentManager.getManager().getCode());
                        String reqUrl = "http://api.clink.cn/interface/PreviewOutcall?enterpriseId=3001162";
                        reqUrl += cno_pwd;

                        reqUrl += "&customerNumber=" + newValue;
                        // reqUrl += "&jsoncallback=?";
                        String url = "javascript:phoneCall('" + reqUrl + "')";
                        // System.out.println("url================" + url);
                        html.a().onclick(url).close();
                        html.append(value.toString());
                        html.nbsp().nbsp().nbsp();
                        if (StringUtils.isNotBlank(newValue)) {
//                            html.img().src(context.getContextPath() + "/assets/ui/themes/base/img/dianhua.jpg").alt("拨打客户电话").end();
                        }
                        html.aEnd();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (property.equalsIgnoreCase("email")) {
                    if (!roleName.equalsIgnoreCase("隐私保护")) {
                        if (value != null && !"".equals(value)) {
                            String newValue = value.toString().trim();
                            if (StringUtils.isNotBlank(newValue) && EmailValidator.isEmail(newValue)) {
                                String firstValue = newValue.substring(0, newValue.indexOf("@"));
                                String secondValue = newValue.substring(newValue.indexOf("@"), newValue.length());
//                                value = firstValue.substring(0, 1) + "******" + firstValue.substring(firstValue.length() - 1, firstValue.length()) + secondValue;
                            }
                        }
                    }
                }

                if (StringUtils.isNotBlank(property) && (property.equalsIgnoreCase("mobile") || property.equalsIgnoreCase("user_mobile") || property.equalsIgnoreCase("receive_address") || property.equalsIgnoreCase("RECOMMENDER_MOBILE") || property.equalsIgnoreCase("RECOMMENDERMOBILE"))) {
                } else {
                    html.append(value.toString());
                }
            } else {
                html.append(value.toString());
            }
        } else {
            html.nbsp();
        }

        html.tdEnd();

        return html.toString();
    }

    // public volatile Column getColumn() {
    // return getColumn();
    // }

}