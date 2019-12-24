package com;

import com.bean.Node;
import com.data.VirtualDataGenerator;

import java.util.*;

/**
 * 名称：MultipleTree
 * 功能：多叉树类 (银行层级方面的功能使用
 * 方法：银行层级方面的功能使用Demo
 * 版本：1.0
 * 作者：xurunhao
 * 日期：2019/12/24 13:48
 * 说明：
 */
public class MultipleTree {
    public static void main(String[] args){
        //读取层次数据结果集列表
        List dataList = VirtualDataGenerator.getVirtualResult();
        //节点列表（散列表，用于临时存储节点对象）
        HashMap nodeList = new HashMap();
        //根节点
        Node root = null;
        //讲结果集构造节点列表(存入散列表)
        for(Iterator it = dataList.iterator(); it.hasNext();){
            Map dataRecord = (Map) it.next();
            Node node = new Node();
            node.id = (String) dataRecord.get("id");
            node.text = (String) dataRecord.get("text");
            node.parentId = (String) dataRecord.get("parentId");
            nodeList.put(node.id, node);
        }
        // 构造无序的多叉树
        Set entrySet = nodeList.entrySet();
        for (Iterator it = entrySet.iterator(); it.hasNext();) {
            Node node = (Node) ((Map.Entry) it.next()).getValue();
            if (node.parentId == null || node.parentId.equals("")) {
                root = node;
            } else {
                ((Node) nodeList.get(node.parentId)).addChild(node);
            }
        }
        // 对多叉树进行横向排序
        root.sortChildren();
        // 输出有序的树形菜单的JSON字符串
        System.out.println(root.toString());
    }
}
