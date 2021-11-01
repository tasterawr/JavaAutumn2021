package org.loktevik.mylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyLinkedList<T> implements List<T> {

    private Node<T> tail;
    private Node<T> head;
    private int size;

    public MyLinkedList(){
        tail = null;
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> cur = tail;
        while(!cur.getValue().equals(o)){
            cur = cur.getNext();

            if (cur == null)
                return false;
        }

        return true;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<T> cur = tail;
        for (int i = 0; i< size(); i++){
            array[i] = cur.getValue();
            cur = cur.getNext();
        }

        return array;
    }

    @Override
    public boolean add(T o) {
        if (tail == null){
            tail = new Node<T>(o, null, null);
            head = tail;
        }
        else{
            Node<T> prev = head;
            head = new Node<T>(o, prev, null);
            prev.setNext(head);
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size() == 1){
            tail = null;
            size--;
            return true;
        }

        Node<T> cur = tail;
        while(!cur.getValue().equals(o)){
            cur = cur.getNext();

            if (cur == null)
                return false;
        }

        if (cur == head){
            Node<T> prev = cur.getPrevious();
            head = prev;
            prev.setNext(null);
        }
        else if (cur == tail){
            tail = tail.getNext();
            tail.setPrevious(null);
        }
        else{
            Node<T> prev = cur.getPrevious();
            Node<T> next = cur.getNext();
            prev.setNext(next);
            next.setPrevious(prev);
        }
        size--;

        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object [] array = c.toArray();
        Node<T> prev = head;
        for (Object o : array) {
            Node<T> next = new Node<T>((T) o, prev, null);
            head = next;
            prev.setNext(next);
            prev = next;
            size++;
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Node<T> cur = tail;
        for (int i = 0; i < index;i++){
            cur = cur.getNext();
        }

        Node<T> prev = cur.getPrevious();
        Object [] array = c.toArray();
        for (int i = 0 ;i < array.length; i++){
            Node<T> next = new Node<T>((T) array[i], prev, null);
            prev.setNext(next);
            prev = next;
            size++;

            if (i == array.length -1){
                prev.setNext(cur);
                cur.setPrevious(prev);
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] objects = c.toArray();
        Node<T> cur = tail;
        for (int i = 0; i < size(); i++){

        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size())
            a = toArray();
        else{
            boolean listIsStored = false;
            Node<T> cur = tail;
            for (int i = 0; i< size(); i++){
                if (!listIsStored){
                    a[i] = cur.getValue();
                    cur = cur.getNext();
                }
                else{
                    a[i] = null;
                }

                if (cur == null){
                    listIsStored = true;
                }
            }
        }
        return a;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        size = 0;
        tail = null;
        head = null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node<T> cur = tail;
        for (int i = 0; i < index; i++){
            cur = cur.getNext();
        }

        return cur.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node<T> cur = tail;
        for (int i = 0; i < index; i++){
            cur = cur.getNext();
        }

        Object previousValue = cur.getValue();
        cur.setValue((T) element);
        return previousValue;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0){
            Node<T> next = tail;
            tail = new Node<T>((T)element, null, next);
        }
        else if (index == size - 1){
            Node<T> prev = head.getPrevious();
            Node<T> next = head;
            head = new Node<T>((T)element, prev, next);
            prev.setNext(head);
            next.setPrevious(head);
        }
        else{
            Node<T> cur = tail;
            int i = 0;
            while (i < index){
                cur = cur.getNext();
                i++;
            }

            Node<T> prev = cur.getPrevious();
            Node<T> next = cur;
            cur = new Node<T>((T)element, prev, next);
            prev.setNext(cur);
            next.setPrevious(cur);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index > size() || index < 0)
            return null;

        Node<T> cur = tail;
        int i = 0;
        while (i < index){
            cur = cur.getNext();
            i++;
        }
        remove(cur.getValue());
        return cur.getValue();
    }

    @Override
    public int indexOf(Object o) {
        Node<T> cur = tail;
        int i = 0;
        while (!cur.getValue().equals(o)){
            cur = cur.getNext();
            i++;

            if (cur == null)
                return -1;
        }

        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> cur = head;
        int i = size - 1;
        while(!cur.getValue().equals(o)){
            cur = cur.getPrevious();
            i--;

            if (cur == null)
                return -1;
        }

        return i;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size)
            throw new IndexOutOfBoundsException();

        List<T> subList = new MyLinkedList<>();
        Node<T> cur = tail;
        for (int i = 0; i <= toIndex; i++){
            if (i >= fromIndex){
                subList.add(cur.getValue());
            }

            cur = cur.getNext();
        }
        return subList;
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }
}
