class FirstLastOccurrence {

    public static void findFirstLast(int[] arr, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        if (first == -1) {
            System.out.println("Value not found");
        } else {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index: " + last);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 5, 6, 5, 9};
        int target = 5;

        findFirstLast(arr, target);
    }
}

