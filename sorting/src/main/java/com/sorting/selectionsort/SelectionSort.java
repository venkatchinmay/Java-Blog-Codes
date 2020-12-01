package com.sorting.selectionsort;

public class SelectionSort {

    private static boolean isSortingRequired(int lowerIndexelement, int heigherIndexElement) {
        return lowerIndexelement > heigherIndexElement;
    }

    private static void swapTheElements(int[] elements, int fromPosition, int toPosition) {
        int temp = elements[fromPosition];
        elements[fromPosition] = elements[toPosition];
        elements[toPosition] = temp;
    }

    private static void printingTheElements(int[] elements) {
        for (int element : elements) {
            System.out.println("element ::" + element);
        }
    }

    // iteration compare starts from the iteration and iteration +1
    // compare smallest and next element
    public static int[] sortingUsingSelectionSort(int[] elements) {
        int position = 0;
        for (int i = 0; i < elements.length; i++) {
            position = i;
            for (int j = position + 1; j < elements.length; j++) {
                if (isSortingRequired(elements[position], elements[j])) {
                    position = j;
                }
            }
            swapTheElements(elements, i, position);
        }
        return elements;
    }

    public static void main(String args[]) {
        int[] elements = { 5, 1, 4, 2, 8 };
        int[] elementsAfterSort = sortingUsingSelectionSort(elements);
        printingTheElements(elementsAfterSort);
    }

}
