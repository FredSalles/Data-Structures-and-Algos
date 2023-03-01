package Practice;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

        int[] originalArray = {5, 8, 3, 2, 7, 9, 1, 4, 6};

        int[] array = originalArray.clone();
        System.out.println("Original");
        printArray(array);

        bubbleSort(array);
        System.out.println("Bubble Sorted");
        printArray(array);

        array = originalArray.clone();
        mergeSort(array, 0 , array.length -1);
        System.out.println("Merge Sorted");
        printArray(array);

        array = originalArray.clone();
        quickSort(array, 0 , array.length -1);
        System.out.println("Quick Sorted");
        printArray(array);
 
    }

    private static void printArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println("[" + index + "] = " + array[index]);
        }
    }

    //////////////////////////////////////////////////////////////////
    // mergesort
    //////////////////////////////////////////////////////////////////
    //
    // split current array in middle
    // sort each side
    // remerge sorted elements
    //
    private static void mergeSort(int[] array, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2 ;
            mergeSort(array, start, middle); 
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);

        }
    }

    //
    // Merges 2 sorted segments
    //
    private static void merge(int[] array, int startIndex, int middleIndex, int endIndex) {

        int[] lowArray = Arrays.copyOfRange(array, startIndex, middleIndex + 1); // final index of the range to be copied, exclusive
        int[] highArray = Arrays.copyOfRange(array, middleIndex + 1, endIndex + 1);

        int lowindex = 0;
        int highindex = 0;

        int lowSize = lowArray.length;
        int highSize = highArray.length;
        int currentIndex = startIndex;

        while (lowindex < lowSize && highindex < highSize) {
            if (lowArray[lowindex] < highArray[highindex]) {
                array[currentIndex] = lowArray[lowindex];
                lowindex++;
            } else {
                array[currentIndex] = highArray[highindex];
                highindex++;
            }
            currentIndex++;
        }

        while (lowindex < lowSize) {
            array[currentIndex] = lowArray[lowindex];
            lowindex++;
            currentIndex++;
        }
        while (highindex < highSize) {
            array[currentIndex] = highArray[highindex];
            highindex++;
            currentIndex++;
        }
    }

    //////////////////////////////////////////////////////////////////
    // quickSort
    //////////////////////////////////////////////////////////////////
    //
    // Takes last element as pivot 
    // smaller (smaller than pivot) to left of pivot
    // all greater elements to right of pivot 
    //
    private static void quickSort(int[] array, int start, int end) {

        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort (array, start, pivot -1);
            quickSort (array, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];
        int pos = start;
        //
        // Partition sort based on last value pivot
        //
        // Bubble down lower values than pivot then place pivot
        //
        for (int index = start ; index < end ; index++) {
            if (array[index] < pivot) {
                int tmp = array[index];
                array[index] = array[pos];
                array[pos] = tmp;
                pos++;
            }
        }
        int tmp = array[end];
        array[end] = array[pos];
        array[pos] = tmp;
        return pos;
    }

    //////////////////////////////////////////////////////////////////
    // bubbleSort
    //////////////////////////////////////////////////////////////////
    //
    // Swap Adjacent Element if not ordered
    //
    private static void bubbleSort(int[] array) {

        int arrayLenght = array.length;
        for (int highestPosition = arrayLenght - 1 ; highestPosition > 0; highestPosition--) {
            boolean swapped = false;
            for (int innerIndex = 0 ; innerIndex < highestPosition ; innerIndex++) {
                if (array[innerIndex]  > array[innerIndex + 1]) {
                    int element = array[innerIndex];
                    array[innerIndex] = array[innerIndex + 1];
                    array[innerIndex + 1] = element;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

    }
}
