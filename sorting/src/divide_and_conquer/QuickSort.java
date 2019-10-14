package divide_and_conquer;

import utilities.SortingUtilities;

import java.util.Arrays;

public class QuickSort
{
    public static final int QS_CUTOFF = 10;

    public static void main(String[] args)
    {
        int[] data = SortingUtilities.generateRandomArray(2000000, 1, 2000000);
        //System.out.println(Arrays.toString(data));
        quicksort(data);
        //System.out.println(Arrays.toString(data));
        System.out.println("Inversions? " + SortingUtilities.detectAdjacentInversions(data));
    }

    public static void quicksort(int[] array)
    {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high)
    {
        //if low & high are out of order or we have
        //one element (sorted)
        if (low >= high)
        {
            return;
        }
        else if (high - low + 1 <= QS_CUTOFF)
        {
            //use insertion sort for small sub-arrays
            insertionSort(array, low, high);
            return;
        }

        //pick our pivot!
        medianOfThree(array, low, high);
        int pivot = array[low];

        //partition
        int i = low + 1;
        int j = high;
        while (i <= j)
        {
            //move each element til it finds
            //something on the wrong side of the
            //partition
            while (array[i] < pivot) { i++; }
            while (array[j] > pivot) { j--; }

            if (i <= j)
            {
                SortingUtilities.swap(array, i, j);

                //update our indices
                i++;
                j--;
            }
        }

        //recurse
        quicksort(array, low, j);
        quicksort(array, i, high);
    }

    private static void medianOfThree(int[] array, int low, int high)
    {
        int  mid = (low + high) / 2;

        //insertion sort low, mid and high
        if (array[low] > array[mid])
        {
            SortingUtilities.swap(array, low, mid);
        }
        if (array[mid] > array[high])
        {
            SortingUtilities.swap(array, mid, high);
        }
        if (array[low] > array[mid])
        {
            SortingUtilities.swap(array, low, mid);
        }

        //our pivot is at mid, move it to low
        SortingUtilities.swap(array, low, mid);
    }

    //insertion sort within a range [low, high]
    private static void insertionSort(int[] array, int low, int high)
    {
        for (int i = low + 1; i <= high; i++)
        {
            for (int j = i; j >= low + 1; j--)
            {
                if (array[j] < array[j - 1])
                {
                    SortingUtilities.swap(array, j, j - 1);
                }
                else
                {
                    break;
                }
            }
        }
    }
}
