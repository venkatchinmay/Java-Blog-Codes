package com.artof.coding.sorting;

import java.util.Comparator;

public interface Sorting<T> {
    /**
     * 
     * we need to implement a sorting algorithm WE NEED TO IMPLEMENT A SORTING ORDER
     * (ASC or DSC) AND SORTED PARAMETER in COMPARATOR interface
     */
    public void sort(T[] elements, Comparator<T> comparator, SortingType sortingType);

    public void exchangingElements(T[] elements, int fromPosition, int toPosition);

    public void printingTheElements(T[] elements);

    public boolean isElementsArePerfectlySorted(T[] elements, Comparator<T> comparator);

    public boolean isElementLess(T object, T object2, Comparator<T> comparator);

}
