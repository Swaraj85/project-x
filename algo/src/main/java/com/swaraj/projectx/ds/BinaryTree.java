package com.swaraj.projectx.ds;

import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    @Data
    static class TreeNode<T> {
        private T data;
        private TreeNode<T> left, right;
    }

    private TreeNode<Integer> rootNode;

    public void add(int key) {
        rootNode = insertNode(rootNode, key);
    }

    public void print() {
        inorderTraversal(rootNode);
    }

    public void traverseLevelOrderOrBfs() {
        Queue<TreeNode<Integer>> traverseQueue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        traverseQueue.add(rootNode); // seed the queue
        while (!traverseQueue.isEmpty()) {
            TreeNode<Integer> tempNodeToPrint = traverseQueue.remove(); // visit the node
            builder.append(tempNodeToPrint.getData() + " ");
            //add left node

            if (Objects.nonNull(tempNodeToPrint.getLeft())) {
                traverseQueue.add(tempNodeToPrint.getLeft());
            }

            //add right node
            if (Objects.nonNull(tempNodeToPrint.getRight())) {
                traverseQueue.add(tempNodeToPrint.getRight());
            }
        }
        System.out.println("builder = " + builder);
    }

    private void inorderTraversal(TreeNode<Integer> node) {
        // visit order --> left, root , right
        // traverse recursively
        if (node != null) {
            System.out.println("going left");
            /*
             * keep going all the way to the left leaf node, stack unwinds once left
             * node is null
             * leaf node = node whose "left" and "right" ref are null
             * */
            inorderTraversal(node.getLeft());
            System.out.println("going left complete");

            /*
             * visit Data bec its "inorder" traversal i.e. LDR
             * */
            System.out.println("node.getData() = " + node.getData());

            /*
             * go all the way to right of subtree which you are visiting
             * */
            System.out.println("going right");
            inorderTraversal(node.getRight());
            System.out.println("going right complete");
        }
    }

    private TreeNode<Integer> insertNode(TreeNode<Integer> root, int key) {
        if (root == null) return getNewNode(key);

        if (key < root.getData()) {
            root.setLeft(insertNode(root.getLeft(), key));
        } else if (key > root.getData()) {
            root.setRight(insertNode(root.getRight(), key));
        }

        return root;
    }

    private TreeNode<Integer> getNewNode(int data) {
        TreeNode<Integer> newNode = new TreeNode<>();
        newNode.setData(data);
        newNode.setLeft(null);
        newNode.setRight(null);
        return newNode;
    }
}
