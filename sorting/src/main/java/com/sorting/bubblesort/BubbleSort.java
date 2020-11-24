package com.sorting.bubblesort;

public class BubbleSort {

    private static void swap(int fromPosition, int toPosition, int[] elements) {
        int temp = elements[fromPosition];
        elements[fromPosition] = elements[toPosition];
        elements[toPosition] = temp;
    }

    private static boolean isSwappingRequired(int smallerIndexElement, int largerIndexElement) {
        return smallerIndexElement > largerIndexElement;
    }

    public static int[] bubbleSort(int[] elements) {

        for (int i = 0; i < elements.length; i++) {
            int position = 0;
            for (int j = 1; j < elements.length; j++) {
                if (isSwappingRequired(elements[position], elements[j])) {
                    swap(position, j, elements);
                }
                position = j;
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
        int[] elements = { 5, 1, 4, 2, 8 };
        int[] elementsAfterSort = bubbleSort(elements);
        printingTheElements(elementsAfterSort);

    }

}
