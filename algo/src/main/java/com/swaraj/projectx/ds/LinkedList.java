package com.swaraj.projectx.ds;

/*
* node 1 ---> start_node
* node 2
* node 3 --> |data | node 4 ref|
* node 4 ----> node 4 -> |data|null| -- >tail node
*
* */
public class LinkedList<T> {
    private int number_of_element = 0;
    private int index = -1;
    private Node<T> start_node;
    private Node<T> tail_node;

    public void addData(T data_to_add) {
        if (number_of_element == 0) {
            start_node = getNewNode(data_to_add);
            tail_node = start_node;
            number_of_element++;
            index++;
        } else {
            //bad way to add node, O(n)
            Node<T> current_node = start_node;

            // stop at second last node, to get reference of last node
            while (current_node.getNext_address() != null) {
                current_node = current_node.getNext_address();
            }

            Node<T> newNode = getNewNode(data_to_add);
            current_node.setNext_address(newNode);
            tail_node = newNode;
            number_of_element++;
            index++;
        }
    }

    public void addDataViaTail(T data_to_add) {
        Node<T> newNode = getNewNode(data_to_add);
        tail_node.setNext_address(newNode);
        number_of_element++;
        index++;
    }

    public int search(T data) {
        int searchIndex = -1;
        Node<T> current_node = start_node;
        while (current_node != null) {
            searchIndex++;
            if (current_node.getData().equals(data)) break;
            current_node = current_node.getNext_address();
        }
        return searchIndex;
    }

    public void print() {
        Node<T> current_node = start_node;
        while (current_node != null) {
            System.out.println("current_node.getData() = " + current_node.getData());
            current_node = current_node.getNext_address();
        }
    }

    private Node<T> getNewNode(T data_to_add) {
        Node<T> new_node = new Node<>();
        new_node.setData(data_to_add);
        new_node.setNext_address(null);
        return new_node;
    }

    public Node<T> getNodeAtIndex(int index) {
        Node<T> tempNode = start_node;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext_address();
        }
        return tempNode;
    }

    public int getCount() {
        return number_of_element;
    }
}
