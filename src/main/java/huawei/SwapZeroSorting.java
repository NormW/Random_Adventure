package huawei;

import java.util.Arrays;

public class SwapZeroSorting {

    // Swap value in array[0] and array[index]
    public void swapZero(int[] array, int length, int index) {
        if (index >= length || array == null) {
            throw new RuntimeException("Index out of bound");
        }

        int tmp = array[0];
        array[0] = array[index];
        array[index] = tmp;
    }

    public void swapSort(int[] array, int length) {
        if(array == null || array.length == 1) {
            return;
        }

        //NOTE after assignment, the original array preference got copied.
        int[] checkedArray = array;
        int[] updated = new int[length];
        for(int i = 0; i < length; i++) {
            updated[i] = getMin(checkedArray, checkedArray.length);
            checkedArray = Arrays.copyOfRange(checkedArray, 1, checkedArray.length);
        }

        for(int i = 0; i < length; i ++) {
            array[i] = updated[i];
        }
    }

    public int getMin(int[] array, int length) {
        for(int i = 0; i < length; i ++) {
            if(array[0] > array[i]) {
                swapZero(array, length, i);
            }
        }
        return array[0];
    }

    public void swapRange(int[] array, int from, int length, int index) {
        int tmp = array[from];
        array[from] = array[index];
        array[index] = tmp;
    }

    public void swapRangeSort(int[] array, int length) {
        for(int i = 0; i < length; i ++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swapRange(array, i, array.length, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwapZeroSorting opr = new SwapZeroSorting();
        int[] array = {1, 1, 5, 4 ,5};
        opr.swapSort(array, 5);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("");

        int[] array2 = {3, 1, 2, 4, 7};
        opr.swapRangeSort(array2, 5);
        for (int value : array2) {
            System.out.print(value + " ");
        }
    }
}
