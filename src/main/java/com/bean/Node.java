package com.bean;

/**
 * 名称：Node
 * 功能：节点类
 * 方法：<方法说明>
 * 版本：1.0
 * 作者：xurunhao
 * 日期：2019/12/24 13:57
 * 说明：<文档编写说明>
 */
public class Node {
    /**
     * 节点编号
     */
    public String id;
    /**
     * 节点内容
     */
    public String text;
    /**
     * 父节点编号
     */
    public String parentId;
    /**
     * 孩子节点列表
     */
    private Children children = new Children();

    // 先序遍历，拼接JSON字符串
    public String toString() {
        String result = "{"
                + "id : '" + id + "'"
                + ", text : '" + text + "'";

        if (children != null && children.getSize() != 0) {
            result += ", children : " + children.toString();
        } else {
            result += ", leaf : true";
        }

        return result + "}";
    }

    // 兄弟节点横向排序
    public void sortChildren() {
        if (children != null && children.getSize() != 0) {
            children.sortChildren();
        }
    }

    // 添加孩子节点
    public void addChild(Node node) {
        this.children.addChild(node);
    }
}
