public class SearchingAlgo{
    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};
        int indexiter = binarySeaarchIterative(arr, 20);
        System.out.println("iterative binary saearch(20):" + indexiter);
        int indexrec = binarySearchrecursive(arr, 0, arr.length - 1, 25);
        System.out.println("recursive binary saearch(25):" + indexrec);
        int indexlinear = linearSearchrecursive(arr, 0, 12);
        System.out.println("linear binary saearch(12):" + indexlinear);
        int minval = findmin(arr, 0);
        int maxval = findmax(arr, 0);
        System.out.println("Minimum:" + minval);
        System.out.println("Maximum:" + maxval);
    }

    static int binarySeaarchIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int binarySearchrecursive(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearchrecursive(arr,mid + 1,high, target);
        else
            return binarySearchrecursive(arr, mid - 1, low, target);
    }

    static int linearSearchrecursive(int[] arr, int index, int target) {
        if (index == arr.length)
            return -1;
        if (arr[index] == target)
            return index;
        return linearSearchrecursive(arr, index + 1, target);
    }

    static int findmin(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.min(arr[index], findmin(arr, index + 1));
    }

    static int findmax(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.max(arr[index], findmax(arr, index + 1));
    }
}
