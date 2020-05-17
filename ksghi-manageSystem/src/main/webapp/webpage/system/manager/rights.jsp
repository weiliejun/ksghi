<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page
        import="com.itech.core.components.xtree.TreeNode,com.itech.ups.base.ApplicationSessionKeys,com.itech.ups.base.application.domain.CurrentManager,java.util.Iterator" %>
<%
    TreeNode functionTree = currentManager.getAuthorityFunctionTree();
%>
<script type="text/javascript">
    Docs = {
        "data": {
            "localStorageDb": "wjk-db",
            "commentsDomain": null,
            "showPrintButton": false,
            "source": true,
            "tests": false,
            "touchExamplesUi": false,
            "commentsUrl": null,
            "signatures": [{
                "long": "abstract",
                "key": "abstract",
                "short": "ABS"
            },
                {
                    "long": "chainable",
                    "key": "chainable",
                    "short": "&gt;"
                },
                {
                    "long": "deprecated",
                    "key": "deprecated",
                    "short": "DEP"
                },
                {
                    "long": "&#9733;",
                    "key": "new",
                    "short": "&#9733;"
                },
                {
                    "long": "preventable",
                    "key": "preventable",
                    "short": "PREV"
                },
                {
                    "long": "private",
                    "key": "private",
                    "short": "PRI"
                },
                {
                    "long": "protected",
                    "key": "protected",
                    "short": "PRO"
                },
                {
                    "long": "readonly",
                    "key": "readonly",
                    "short": "R O"
                },
                {
                    "long": "removed",
                    "key": "removed",
                    "short": "REM"
                },
                {
                    "long": "required",
                    "key": "required",
                    "short": "REQ"
                },
                {
                    "long": "static",
                    "key": "static",
                    "short": "STA"
                },
                {
                    "long": "template",
                    "key": "template",
                    "short": "TMP"
                }],
            "videos": [],
            "classes": [],
            "guides": [],
            "examples": [<%out.print(convertTreeRootToString(request.getContextPath(),functionTree));%>]
        }
    };

</script>

<%!
    public String convertTreeRootToString(String contextPath, TreeNode node) {
        String treeText = "";
        int i = 0;
        Iterator<TreeNode> it = node.getChildren().iterator();
        while (it.hasNext()) {
            TreeNode temp = (TreeNode) it.next();
            if (i == 0) {
                treeText = treeText + (convertTreeToString(contextPath, temp));
            } else {
                treeText = treeText + "," + (convertTreeToString(contextPath, temp));
            }
            i = i + 1;
        }
        return treeText;
    }

    public String convertTreeToString(String contextPath, TreeNode node) {
        String treeText = "";
        String id = node.getId();
        String name = node.getName();
        String url = "";
        if (node.isLeaf()) {
            url = contextPath + (String) node.getAttribute("url");
            treeText = "{'description':'" + name + "','title':'" + name + "', 'name':'" + id + "', 'status':'new', 'url':'" + url + "'}";
        } else {
            treeText = "{'description':'" + name + "','title':'" + name + "', 'name':'" + id + "', 'status':'new','items':[";
            Iterator<TreeNode> it = node.getChildren().iterator();
            int i = 0;
            while (it.hasNext()) {
                TreeNode temp = (TreeNode) it.next();
                if (i == 0) {
                    treeText = treeText + (convertTreeToString(contextPath, temp));
                } else {
                    treeText = treeText + "," + (convertTreeToString(contextPath, temp));
                }
                i = i + 1;
            }
            treeText = treeText + "]}";
        }
        return treeText;
    }
%>
