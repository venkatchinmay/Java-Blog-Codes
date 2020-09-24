package com.artof.coding.sorting;

import java.util.Comparator;

public interface Sorting<T> {
    /**
     * 
     * we need to implement a sorting algorithm
     */
    public void sort(T[] elements);

    /**
     * 
     * WE NEED TO IMPLEMENT A SORTING ORDER (ASC or DSC) AND SORTED PARAMETER in
     * COMPARATOR interface
     */
    public boolean isElementLess(Comparator<T> comparator);

    public void exchangingElements(T[] elements, int fromPosition, int toPosition);

    public void printingTheElements(T[] elements);

    public boolean isElementsArePerfectlySorted(T[] elements);

}
