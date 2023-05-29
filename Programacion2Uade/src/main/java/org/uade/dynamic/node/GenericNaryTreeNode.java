package org.uade.dynamic.node;

import org.uade.dynamic.definitions.IGenericNaryTree;

import java.util.List;

public class GenericNaryTreeNode {

    private int value;
    private List<IGenericNaryTree> children;

    public GenericNaryTreeNode(int value, List<IGenericNaryTree> children) {
        this.value = value;
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<IGenericNaryTree> getChildren() {
        return children;
    }

    public void setChildren(List<IGenericNaryTree> children) {
        this.children = children;
    }
}
