package com.swaraj.projectx.ds;

import lombok.Data;

@Data
public class Node<T> {
    private T data;
    private Node<T> next_address;
}
