public class BinarySearchRecursive {

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearchRecursive(arr, low, mid - 1, target);
        }

        return binarySearchRecursive(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 12, 15, 20, 25};
        int target = 12;

        int result = binarySearchRecursive(arr, 0, arr.length - 1, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Found at index: " + result);
        }
    }
}
