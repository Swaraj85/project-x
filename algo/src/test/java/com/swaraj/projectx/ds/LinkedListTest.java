package com.swaraj.projectx.ds;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void iterate() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addData(1);
        linkedList.addData(24);
        linkedList.addData(36);
        linkedList.addData(477);
        linkedList.addDataViaTail(500);
        linkedList.addDataViaTail(502);

        assertEquals(6, linkedList.getCount());
        linkedList.print();
    }

    @Test
    void search() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addData(1);
        linkedList.addData(24);
        linkedList.addData(36);
        assertEquals(1, linkedList.search(24));
        assertEquals(2, linkedList.search(36));
    }

    @Test
    void retrieval() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addData(1);
        linkedList.addData(24);
        linkedList.addData(36);
        assertEquals(linkedList.getNodeAtIndex(2).getData(), 36);
    }
}