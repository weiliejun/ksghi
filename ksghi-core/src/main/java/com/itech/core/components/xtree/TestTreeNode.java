package com.itech.core.components.xtree;

import org.apache.log4j.Logger;

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

public class TestTreeNode {
    private static Logger logger = Logger.getLogger(TestTreeNode.class);

    public static void main(String[] str) {
        TreeNode tree = new TreeNode("001", "甫夫妇1");
        TreeNode tree1 = new TreeNode("002", "甫夫妇2");
        TreeNode tree2 = new TreeNode("003", "甫夫妇3");
        TreeNode tree3 = new TreeNode("004", "甫夫妇4");

        tree.add(tree1);
        tree1.add(tree2);
        tree2.add(tree3);

        String name = TreeNodeUtils.getNameForRecursion(tree3, "-");
        logger.info(name);
    }
}
