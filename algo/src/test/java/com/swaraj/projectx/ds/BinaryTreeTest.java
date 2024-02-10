package com.swaraj.projectx.ds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    static BinaryTree binaryTree = new BinaryTree();

    @BeforeAll
    public static void init() {
        binaryTree.add(50);
        binaryTree.add(20);
        binaryTree.add(90);
        binaryTree.add(10);
        binaryTree.add(60);
        binaryTree.add(100);
    }
    @Test
    void create_binary_search_tree() {
        /*
        *
going left
going left
going left
going left complete
node.getData() = 10
going right
going right complete
going left complete
node.getData() = 20
going right
going right complete
going left complete
node.getData() = 50
going right
going left
going left
going left complete
node.getData() = 60
going right
going right complete
going left complete
node.getData() = 90
going right
going left
going left complete
node.getData() = 100
going right
going right complete
going right complete
going right complete

Process finished with exit code 0

        * */

        binaryTree.print();
    }

    @Test
    void bfs_traverse() {
        binaryTree.traverseLevelOrderOrBfs();
    }
}