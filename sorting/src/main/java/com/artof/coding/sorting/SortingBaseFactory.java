package com.artof.coding.sorting;

import java.util.Comparator;

public class SortingBaseFactory<T> implements Sorting<T> {

    @Override
    public void sort(T[] elements, Comparator<T> comparator, SortingType sortingType) {
        if (sortingType.equals(SortingType.SELECTIONSORT)) {
            selectionSort(elements, comparator);
        }

    }

    @Override
    public void exchangingElements(T[] elements, int fromPosition, int toPosition) {
        T temp = elements[fromPosition];
        elements[fromPosition] = elements[toPosition];
        elements[toPosition] = temp;
    }

    @Override
    public void printingTheElements(T[] elements) {
        for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i] + " ");

    }

    @Override
    public boolean isElementsArePerfectlySorted(T[] elements, Comparator<T> comparator) {
        for (int i = 1; i < elements.length; i++)
            if (isElementLess(elements[i], elements[i - 1], comparator))
                return false;
        return true;

    }

    @Override
    public boolean isElementLess(T presentElement, T previousElement, Comparator<T> comparator) {
        /**
         * if it return -1 less if it returns 1 greater than
         */
        return comparator.compare(presentElement, previousElement) < 0;

    }

    /**
     * 
     * 1. place most smallest element in first position 2. place next smallest
     * element in second position ..... 3. finally all elements will be sorted in
     * that passion( * Comparisions ::: N^2 and * Exchanges ::: N ) running time is
     * insensitive to the input
     */
    private void selectionSort(T[] elements, Comparator<T> comparator) {
        int minElementPosition = 0;
        for (int i = 1; i < elements.length; i++) {
            minElementPosition = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (isElementLess(elements[j], elements[minElementPosition], comparator)) {
                    minElementPosition = j;
                }
            }
            exchangingElements(elements, minElementPosition, i);
        }
    }

    private void insertionSort(T[] elements, Comparator<T> comparator) {
        for (int i = 1; i < elements.length; i++) {

        }
    }

}
