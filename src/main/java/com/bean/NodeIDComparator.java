package com.bean;

import java.util.Comparator;

/**
 * 名称：NodeIDComparator
 * 功能：节点比较器
 * 方法：<方法说明>
 * 版本：1.0
 * 作者：xurunhao
 * 日期：2019/12/24 13:59
 * 说明：<文档编写说明>
 */
public class NodeIDComparator implements Comparator {
    // 按照节点编号比较
    public int compare(Object o1, Object o2) {
        int j1 = Integer.parseInt(((Node) o1).id);
        int j2 = Integer.parseInt(((Node) o2).id);
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
}
