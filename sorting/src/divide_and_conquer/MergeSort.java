package divide_and_conquer;

import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    private static int[] temp;

    public static void main(String[] args)
    {
        //simple test
        int[] smallArr = {9, 3, 1, 10, 9, 4, 2, 3};
        //smallArr = generateRandomArray(1000, 1, 1000);

        System.out.println("Input arr: " + Arrays.toString(smallArr));
        mergeSort(smallArr);
        System.out.println("After sort: " + Arrays.toString(smallArr));

        System.out.println("Inversions? " + detectAdjacentInversions(smallArr));
    }

    public static void mergeSort(int[] array)
    {
        //get ready for our sort!
        if (array.length <= 1)
        {
            return;
        }

        //create an auxiliary array to hold elements
        //during the merge steps
        temp = new int[array.length];

        //then do the work!
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high)
    {
        //base case - a single element is sorted
        if (high == low)
        {
            return;
        }

        //sort the left and right side of the array
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, high);
    }

    private static void merge(int[] array, int low, int high)
    {
        //create a few housekeeping variables
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;

        //loop for every element to merge
        for (int i = low; i <= high; i++)
        {
            if (left > mid) //no more elements on the left
            {
                temp[i] = array[right++];
            }
            else if (right > high) //no more elements on the right
            {
                temp[i] = array[left++];
            }
            else if (array[left] <= array[right]) //if the left value is smallest
            {
                temp[i] = array[left++];
            }
            else //if (array[right] < array[left]) //if the right value is smallest
            {
                temp[i] = array[right++];
            }
        }

        //copy elements back to the original array
        for (int i = low; i <= high; i++)
        {
            array[i] = temp[i];
        }
    }

    private static void swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static boolean detectAdjacentInversions(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return true;
            }
        }

        return false;
    }

    private static int[] generateRandomArray(int size, int low, int high)
    {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = low + random.nextInt(high - low + 1);
        }

        return array;
    }
}
