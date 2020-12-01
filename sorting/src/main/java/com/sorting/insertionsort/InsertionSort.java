package com.sorting.insertionsort;

public class InsertionSort {

    private static boolean isSortingRequired(int lowerIndexElement, int heigherIndexElement) {
        return lowerIndexElement > heigherIndexElement;
    }

    private static void swapTheElements(int[] elements, int fromIndex, int toIndex) {
        int temp = elements[fromIndex];
        elements[fromIndex] = elements[toIndex];
        elements[toIndex] = temp;
    }
    // 0,1,2,3

    // 2 > 3
    // 1 > 2
    // 0 > 1
    public static int[] insertionSort(int[] elements) {
        int position = 0;
        for (int i = 0; i < elements.length; i++) {
            position = i;
            for (int j = position; (j < (elements.length - 1) && j >= 0); j--) {
                if (isSortingRequired(elements[j], elements[j + 1])) {
                    swapTheElements(elements, j, j + 1);
                }
            }
        }
        return elements;
    }

    private static void printingTheElements(int elements[]) {
        for (int element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        int[] elements = { 5, 1, 4, 8, 2 };
        int[] elementsAfterSort = insertionSort(elements);
        printingTheElements(elementsAfterSort);

    }

}
