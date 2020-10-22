package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.UnaryOperator;

/* 
Общий список
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized Long remove(int index) {
        Long ext = original.remove(index);
        return ext;
    }

    @Override
    public synchronized void add(int index, Long element) {
        original.add(index, element);
    }

    @Override
    public synchronized Long get(int index) {
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    public synchronized boolean add(Long aLong) {
        boolean bool = original.add(aLong);
        return bool;
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        List list = original.subList(fromIndex, toIndex);
        return list;
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        ListIterator list = original.listIterator(index);
        return list;
    }

    @Override
    public synchronized Spliterator spliterator() {
        Spliterator split = original.spliterator();
        return split;
    }

    @Override
    public synchronized ListIterator listIterator() {
        ListIterator list = original.listIterator();
        return list;
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        int index = original.lastIndexOf(o);
        return index;
    }

    @Override
    public synchronized int indexOf(Object o) {
        int index = original.indexOf(o);
        return index;
    }


    @Override
    public synchronized void sort(Comparator c) {
        original.sort(c);
    }

    @Override
    public synchronized void clear() {
        original.clear();
    }

    @Override
    public synchronized void replaceAll(UnaryOperator operator) {
        original.replaceAll(operator);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        boolean retain = original.retainAll(c);
        return retain;
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        boolean remAll = original.removeAll(c);
        return remAll;
    }

    @Override
    public synchronized boolean addAll(int index, Collection c) {
        boolean add = original.addAll(index, c);
        return add;
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        boolean cont = original.containsAll(c);
        return cont;
    }

    @Override
    public synchronized boolean remove(Object o) {
        boolean remove = original.remove(o);
        return remove;
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        boolean add = original.addAll(c);
        return add;
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return original.toArray(a);
    }

    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }
}
