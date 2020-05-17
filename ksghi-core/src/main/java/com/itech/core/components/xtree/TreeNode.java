package com.itech.core.components.xtree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * ===========================================================================
 * Copyright 2006 OZTIME Corp. All Rights Reserved.
 * OZTIME PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-2-2
 * @author  Chen Gang
 * ===========================================================================
 *
 */

public class TreeNode implements Cloneable, Serializable {

    private static final long serialVersionUID = 7126823466461184432L;

    private String id;

    private String name;

    private TreeNode parent;

    private List children;

    private Map attributes;

    public TreeNode(String id, String name) {

        super();
        this.id = id;
        this.name = name;
        this.parent = null;
        this.children = new LinkedList();
        this.attributes = new HashMap();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void insert(int childIndex, TreeNode newChild) {
        if (newChild == null) {
            throw new IllegalArgumentException("new child is null");
        } else if (isNodeAncestor(newChild)) {
            throw new IllegalArgumentException("new child is an ancestor");
        }

        TreeNode oldParent = (TreeNode) newChild.getParent();

        if (oldParent != null) {
            oldParent.remove(newChild);
        }
        newChild.setParent(this);
        if (children == null) {
            children = new LinkedList();
        }
        children.add(childIndex, newChild);
    }

    public void add(TreeNode newChild) {
        if (newChild != null && newChild.getParent() != null && newChild.getParent().equals(this))
            insert(getChildCount() - 1, newChild);
        else
            insert(getChildCount(), newChild);
    }

    public void remove(int childIndex) {
        TreeNode child = (TreeNode) getChildAt(childIndex);
        children.remove(childIndex);
        child.setParent(null);
    }

    public void remove(TreeNode aChild) {
        if (aChild == null) {
            throw new IllegalArgumentException("argument is null");
        }

        if (!isNodeChild(aChild)) {
            throw new IllegalArgumentException("argument is not a child");
        }
        remove(getIndex(aChild)); // linear search
    }

    public void removeAllChildren() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            remove(i);
        }
    }

    public void removeFromParent() {
        TreeNode parent = (TreeNode) getParent();
        if (parent != null) {
            parent.remove(this);
        }
    }

    public TreeNode getChildAt(int index) {
        if (children == null) {
            throw new ArrayIndexOutOfBoundsException("node has no children");
        }
        return (TreeNode) children.get(index);
    }

    public int getIndex(TreeNode aChild) {
        if (aChild == null) {
            throw new IllegalArgumentException("argument is null");
        }

        if (!isNodeChild(aChild)) {
            return -1;
        }
        return children.indexOf(aChild); // linear search
    }

    public int getChildCount() {
        if (children == null) {
            return 0;
        } else {
            return children.size();
        }
    }

    public boolean isNodeAncestor(TreeNode anotherNode) {
        if (anotherNode == null) {
            return false;
        }

        TreeNode ancestor = this;

        do {
            if (ancestor.equals(anotherNode)) {
                return true;
            }
        } while ((ancestor = ancestor.getParent()) != null);

        return false;
    }

    public boolean isNodeDescendant(TreeNode anotherNode) {
        if (anotherNode == null)
            return false;

        return anotherNode.isNodeAncestor(this);
    }

    public TreeNode getRoot() {
        TreeNode ancestor = this;
        TreeNode previous;

        do {
            previous = ancestor;
            ancestor = ancestor.getParent();
        } while (ancestor != null);

        return previous;
    }

    public boolean isRoot() {
        return getParent() == null;
    }

    public boolean isNodeChild(TreeNode aNode) {
        boolean retval;

        if (aNode == null) {
            retval = false;
        } else {
            if (getChildCount() == 0) {
                retval = false;
            } else {
                retval = (aNode.getParent().equals(this));
            }
        }
        return retval;
    }

    public TreeNode getFirstChild() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(0);
    }

    public TreeNode getLastChild() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public boolean isLeaf() {
        return (getChildCount() == 0);
    }

    public TreeNode getFirstLeaf() {
        TreeNode node = this;
        while (!node.isLeaf()) {
            node = (TreeNode) node.getFirstChild();
        }
        return node;
    }

    public TreeNode getLastLeaf() {
        TreeNode node = this;
        while (!node.isLeaf()) {
            node = (TreeNode) node.getLastChild();
        }
        return node;
    }

    public Object clone() {
        TreeNode newNode = null;

        try {
            newNode = (TreeNode) super.clone();
            // newNode.children = null;
            newNode.parent = null;

        } catch (CloneNotSupportedException e) {
            throw new Error(e.toString());
        }

        return newNode;
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + id.hashCode();
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof TreeNode))
            return false;
        TreeNode anotherTreeNode = (TreeNode) obj;
        return (id.equals(anotherTreeNode.getId()));
    }
}
