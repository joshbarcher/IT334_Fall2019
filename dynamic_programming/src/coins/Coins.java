package coins;

import java.util.Arrays;

public class Coins
{
    public static void main(String[] args)
    {
        int[] coins = {1, 5, 10, 25, 50};
        int value = 67;
        int min = minCoins(value, coins);
        System.out.println("Min coins for " + value + " is " + min);
    }

    //what is the minimum number of coins that it takes
    //to get value n?
    public static int minCoins(int n, int[] coins)
    {
        int[] values = new int[n + 1];

        //initialize the values in the array
        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;

        for (int i = 0; i < values.length; i++)
        {
            //if we can create this value...
            if (values[i] < Integer.MAX_VALUE)
            {
                for (int j = 0; j < coins.length; j++)
                {
                    //determine if the next index is an improvement
                    int nextIndex = i + coins[j];
                    if (nextIndex < values.length &&
                        values[i] + 1 < values[nextIndex])
                    {
                        values[nextIndex] = values[i] + 1;
                    }
                }
            }
        }
        return values[n];
    }
}
