package other_sorts;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NaiveHeapSort
{
    public static void main(String[] args)
    {
        int[] array = {10, 5, -10, 60, 12, 1, 67, 89, 1, 2, 5};

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int element : array)
        {
            heap.add(element);
        }

        int count = 0;
        while (!heap.isEmpty())
        {
            array[count] = heap.poll();
            count++;
        }

        System.out.println(Arrays.toString(array));
    }
}
