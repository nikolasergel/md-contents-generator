package by.serhel.contentsgeneretor.entity;

import java.util.List;

public class CustomNode {
    private String name;
    private String reference;
    private int titleLevel;
    private CustomNode parent;
    private CustomNode next;
    private List<CustomNode> children;

    public CustomNode() {
    }

    public CustomNode(String name, String reference, int titleLevel) {
        this.name = name;
        this.reference = reference;
        this.titleLevel = titleLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(int titleLevel) {
        this.titleLevel = titleLevel;
    }

    public CustomNode getParent() {
        return parent;
    }

    public void setParent(CustomNode parent) {
        this.parent = parent;
    }

    public CustomNode getNext() {
        return next;
    }

    public void setNext(CustomNode next) {
        this.next = next;
    }

    public List<CustomNode> getChildren() {
        return children;
    }

    public void setChildren(List<CustomNode> children) {
        this.children = children;
    }
}
