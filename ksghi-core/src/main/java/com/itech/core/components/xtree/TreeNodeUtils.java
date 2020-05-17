package com.itech.core.components.xtree;

import java.io.UnsupportedEncodingException;

/*
 * ===========================================================================
 * Copyright 2006 OZTIME Corp. All Rights Reserved.
 * OZTIME PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-4-2
 * @author  Chen Gang
 * ===========================================================================
 *
 */

public class TreeNodeUtils {

    /**
     * 递归的获得 Node Name
     *
     * @param node
     * @param spaceMark 间隔符号 return String 格式为"ParentNode Name"+"spaceMark"+"Node
     *                  Name"
     * @throws UnsupportedEncodingException
     */
    static public String getNameForRecursion(TreeNode node, String spaceMark) {
        String name = node.getName();
        TreeNode parent = (TreeNode) node.getParent();
        if (parent != null) {
            name = getNameForRecursion(parent, spaceMark) + spaceMark + name;
        }
        return name;
    }

}
