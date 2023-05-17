package org.uade.dynamic;

import org.uade.adt.definitions.ILinkedList;
import org.uade.adt.node.Node;

public class LinkedList implements ILinkedList {

    private Node first;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(int value) {
        Node newGenericNode = new Node(value, null);
        if(this.first == null) {
            this.first = newGenericNode;
            this.size++;
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(newGenericNode);
        this.size++;
    }

    @Override
    public void insert(int index, int value) {
        if(index < 0 || index > size) {
            System.out.println("Error, rango excedido");
            return;
        }
        if(index == 0) {
            this.first = new Node(value, this.first);
            return;
        }
        int count = 1;
        Node candidate = this.first;
        while(count != index) {
            candidate = candidate.getNext();
            count++;
        }
        candidate.setNext(new Node(value, candidate.getNext()));
    }

    @Override
    public void remove(int index) {
        if(this.first == null || index < 0 || index > size) {
            System.out.println("Error, rango excedido");
            return;
        }
        if(index == 0) {
            this.first = this.first.getNext();
            return;
        }
        int count = 1;
        Node candidate = this.first;
        while(count != index) {
            candidate = candidate.getNext();
            count++;
        }
        candidate.setNext(candidate.getNext().getNext());
    }

    @Override
    public int get(int index) {
        if(this.first == null) {
            System.out.println("Lista vacia");
            return -1;
        }
        if(index == 0) {
            return this.first.getValue();
        }
        int count = 0;
        Node candidate = this.first;
        while(count != index) {
            candidate = candidate.getNext();
            count++;
        }
        return candidate.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
