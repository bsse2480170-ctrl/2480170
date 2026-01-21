public class RecursionProblems {
    public static void main(String[] args) {
        int fact = factorial(5);
        System.out.println("Factorial of 5:"+fact);

        int fib=fibonacci(6);
        System.out.println("Fibonacci number at position 6:"+fib);

        int[] arrSum={2,4,6,8};
        int sum= sumArray(arrSum,0);
        System.out.println("Sum of all the elements in the array:"+sum);

        int[] arrsort={3,5,7,9};
        boolean sorted= isSorted(arrsort,0);
        System.out.println("Sorted array:"+sorted);

        int[] arrMinMax={7,2,9,4,6};
        int min=findMin(arrMinMax,0);
        int max=findMax(arrMinMax,0);
        System.out.println("Min or Max:"+min);
        System.out.println("Max or Min:"+max);
    }

    static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
            return n * factorial(n - 1);
    }
    static int fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    static int sumArray(int[] arr, int index) {
        if(index == arr.length)
            return 0;
        return arr[index] + sumArray(arr, index+1);
    }
    static boolean isSorted(int[] arr, int index) {
        if (index==arr.length-1)
            return true;
        if (arr[index]>arr[index+1])
            return false;
        return isSorted(arr, index+1);
    }
    static int findMin(int[] arr, int index) {
        if (index==arr.length-1)
            return arr[index];
        return Math.min(arr[index],findMin(arr,index+1));
    }
    static int findMax(int[] arr, int index) {
        if (index==arr.length-1)
            return arr[index];
        return Math.max(arr[index],findMax(arr,index+1));
    }
}

