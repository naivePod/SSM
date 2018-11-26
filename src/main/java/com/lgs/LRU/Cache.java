package com.lgs.LRU;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lgs
 * @Date: 2018-11-23 15:02
 * @Description:
 */
public class Cache<K, V> {
    private Map<K, Node> map = new HashMap();
    private static final int MAX_CACHE_SIZE = 5;
    private Node head;
    private Node tail;
    public Node get() {
        return new Node();
    }

    public void put() {

    }

    class Node {
        Node pre;
        Node next;
        K k;
    }
}
