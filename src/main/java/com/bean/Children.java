package com.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 名称：<名称>
 * 功能：<功能描述>
 * 方法：<方法说明>
 * 版本：1.0
 * 作者：xurunhao
 * 日期：2019/12/24 13:58
 * 说明：<文档编写说明>
 */
public class Children {

    private List list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public void addChild(Node node) {
        list.add(node);
    }

    // 拼接孩子节点的JSON字符串
    public String toString() {
        String result = "[";
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            result += ((Node) it.next()).toString();
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    // 孩子节点排序
    public void sortChildren() {
        // 对本层节点进行排序
        // 可根据不同的排序属性，传入不同的比较器，这里传入ID比较器
        Collections.sort(list, new NodeIDComparator());
        // 对每个节点的下一层节点进行排序
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            ((Node) it.next()).sortChildren();
        }
    }
}

