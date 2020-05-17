package com.itech.ups.app.system.authority.action.function;

import com.itech.core.components.xtree.TreeNode;
import com.itech.core.util.BeanHelper;
import com.itech.ups.app.authority.application.domain.Function;

import java.util.Iterator;
import java.util.List;

/**
 * 版本信息：v1.0 日期：2011-12-24 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class FunctionTreeBuildHelper {

    public static void buildSubTree(TreeNode parent, List<Function> rlist) {
        String code = parent.getId();
        for (int i = 0; i < rlist.size(); i++) {
            Function function = (Function) rlist.get(i);
            if (function.getParentCode() != null && function.getParentCode().equals(code)) {
                TreeNode node = new TreeNode(function.getCode(), function.getName());
                node.addAttribute("parentId", function.getParentCode());
                node.addAttribute("url", function.getUrl());
                node.addAttribute("nodeType", function.getNodeType());
                node.addAttribute("sequence", function.getSeqnum());
                node.addAttribute("status", function.getStatus());
                node.addAttribute("icon", function.getIcon());
                parent.add(node);
                rlist.remove(i);
                i = i - 1;
            }
        }
        List<TreeNode> slist = parent.getChildren();
        if (slist != null && !slist.isEmpty()) {
            Iterator<TreeNode> it = slist.iterator();
            while (it.hasNext()) {
                buildSubTree((TreeNode) it.next(), rlist);
            }
        }
    }

    public static String convertTreeToCheckZtreeString(TreeNode node, boolean isRoot, List selectedObjs) {
        String treeText = "";
        String id = node.getId();
        String name = node.getName();
        String parentId = (String) node.getAttribute("parentId");
        if (isRoot)
            treeText = "{ id:\"" + id + "\", name:\"" + name + "\", open:true , nocheck:true}";
        else {
            boolean checked = false;
            if (selectedObjs != null && !selectedObjs.isEmpty()) {
                Iterator it = selectedObjs.iterator();
                while (it.hasNext()) {
                    Object obj = it.next();
                    try {
                        String code = (String) BeanHelper.getDeclaredProperty(obj, "code");
                        if (code != null && code.equals(id)) {
                            checked = true;
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
            if (checked) {
                treeText = "{ id:\"" + id + "\", pId:\"" + parentId + "\", name:\"" + name + "\",checked:true}";
            } else {
                treeText = "{ id:\"" + id + "\", pId:\"" + parentId + "\", name:\"" + name + "\"}";
            }
        }
        if (!node.isLeaf()) {
            Iterator<TreeNode> it = node.getChildren().iterator();
            while (it.hasNext()) {
                TreeNode temp = (TreeNode) it.next();
                treeText = treeText + "," + (convertTreeToCheckZtreeString(temp, false, selectedObjs));
            }
        }
        return treeText;
    }

    public static String convertTreeToZtreeString(TreeNode node, boolean isRoot) {
        String treeText = "";
        String id = node.getId();
        String name = node.getName();
        String parentId = (String) node.getAttribute("parentId");
        String nodeType = (String) node.getAttributes().get("nodeType");
        if (isRoot)
            treeText = "{ id:\"" + id + "\", name:\"" + name + "\", open:true}";
        else {
            treeText = "{ id:\"" + id + "\", pId:\"" + parentId + "\", name:\"" + name + "\", nodeType:\"" + nodeType + "\"}";
        }
        if (!node.isLeaf()) {
            Iterator<TreeNode> it = node.getChildren().iterator();
            while (it.hasNext()) {
                TreeNode temp = (TreeNode) it.next();
                treeText = treeText + "," + (convertTreeToZtreeString(temp, false));
            }
        }
        return treeText;
    }
}
