package basic_sorts;

import java.util.Random;

public class BasicSorts
{
    public static void main(String[] args)
    {
        int[] numbers = {42, 24, 41, 8, 11, 23, 8, 142, 420, 1237, 0};
        numbers = generateRandomArray(1000000, 1, 1000000);
        selectionSort(numbers);

        for (int number: numbers)
        {
            System.out.println(number);
        }
        System.out.println();

        //is it sorted?
        System.out.println("Sorted? " + !detectAdjacentInversions(numbers));
    }

    public static void bubbleSort(int[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return; // already sorted
        }

        for (int i = 0; i < array.length - 1; i++)
        {
            //elements after array.length - 1 - i are already sorted
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array)
    {
        // for each element starting with the second element (the first is
        // already sorted)
        for (int i = 1; i < array.length; i++)
        {
            // loop down to the first element swapping the current
            // element with any other elements that are higher than it
            for (int j = i; j >= 1; j--)
            {
                if (array[j] < array[j - 1])
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    // stop now, since all elements to the left are already sorted
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return; // already sorted
        }

        // make n selections, where n is array.length
        for (int i = 0; i < array.length; i++)
        {
            int smallest = array[i];
            int smallestIndex = i;

            // find the next smallest element for index i
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < smallest)
                {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            // swap whatever is in index i with the next smallest element
            swap(array, i, smallestIndex);
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