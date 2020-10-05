package com.artof.coding.sorting;

import java.util.Comparator;

public class SortingBaseFactory<T> implements Sorting<T> {

    @Override
    public T[] sort(T[] elements, Comparator<T> comparator, SortingType sortingType) throws Exception {
        if (sortingType.equals(SortingType.SELECTIONSORT)) {
            return selectionSort(elements, comparator);
        } else if (sortingType.equals(SortingType.INSERTIONSORT)) {
            return insertionSort(elements, comparator);
        } else if (sortingType.equals(SortingType.SHELLSORT)) {
            return shellSort(elements, comparator);
        } else {
            throw new Exception("ILLEGAL SORTING TYPE");
        }

    }

    public T[] sort(T[] elements, Comparator<T> comparator) throws Exception {
        return sort(elements, comparator, SortingType.SHELLSORT);
    }

    @Override
    public void exchangingElements(T[] elements, int fromPosition, int toPosition) {
        T temp = elements[fromPosition];
        elements[fromPosition] = elements[toPosition];
        elements[toPosition] = temp;
    }

    @Override
    public String printingTheElements(T[] elements) {
        String result = "";
        for (int i = 0; i < elements.length; i++)
            result = result.concat("(").concat(String.valueOf(i)).concat(")").concat(elements[i].toString());
        return result;
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
    private T[] selectionSort(T[] elements, Comparator<T> comparator) {
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
        return elements;
    }

    /**
     * element | | | SMALLEST ELEMENT , comparision will takes place at element to
     * element
     * 
     * @param elements
     * @param comparator
     */
    private T[] insertionSort(T[] elements, Comparator<T> comparator) {
        for (int i = 1; i < elements.length; i++) {
            // Insert a[i] among a[i-1], a[i-2*1],
            // a[i-3*1]... .
            for (int j = i; (j > 0 && j < elements.length
                    && isElementLess(elements[j], elements[j - 1], comparator)); j--) {
                exchangingElements(elements, j, j - 1);
            }
        }
        return elements;
    }

    private T[] shellSort(T[] elements, Comparator<T> comparator) {
        int shellLength = 1;
        int sizeOfAnElements = elements.length;
        while (shellLength < sizeOfAnElements / 3) {
            shellLength = (shellLength * 3) + 1;
        }
        // shell selection
        for (int selectedShellLength = shellLength; selectedShellLength >= 1; selectedShellLength = selectedShellLength
                / 3) {
            // Apply insertion Sort only for the selectedShell to totalSizeOfAnElements
            for (int i = selectedShellLength; i < sizeOfAnElements; i++) {
                // insertion will be happened
                // Insert a[i] among a[i-selectedShellLength], a[i-2*selectedShellLength],
                // a[i-3*selectedShellLength]... .
                for (int j = i; j >= selectedShellLength && isElementLess(elements[j],
                        elements[j - selectedShellLength], comparator); j = j - (selectedShellLength)) {
                    exchangingElements(elements, j, j - selectedShellLength);
                }
            }
        }
        return elements;
    }

}
