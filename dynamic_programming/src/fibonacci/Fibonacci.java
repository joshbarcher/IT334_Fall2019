package fibonacci;

public class Fibonacci
{
    private static long[] fibCache;

    public static void main(String[] args)
    {
        System.out.println("fib(0): " + fibStart(0));
        System.out.println("fib(5): " + fibStart(5));
        System.out.println("fib(10): " + fibStart(10));
        System.out.println("fib(20): " + fibStart(20));
        System.out.println("fib(50): " + fibStart(50));
    }

    public static long fibStart(int n)
    {
        fibCache = new long[n];

        return fibSavedProblems(n);
    }

    private static long fibSavedProblems(int n)
    {
        System.out.println("fib(n): " + n);
        if (n == 0 || n == 1)
        {
            return n;
        }

        long fib1 = findFib(n - 1);
        long fib2 = findFib(n - 2);

        return fib1 + fib2;
    }

    //look in the cache for fib(n)
    private static long findFib(int n)
    {
        //if the value is not in the cache
        if (fibCache[n] == 0)
        {
            //calculate the value
            fibCache[n] = fibSavedProblems(n);
        }
        return fibCache[n];
    }

    public static int fib(int n)
    {
        System.out.println("fib(" + n + ")");
        //base case
        if (n == 0 || n == 1)
        {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
