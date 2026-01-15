public class LL {

    Node head;
    private int size;

    LL() { size = 0; }

    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print the list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // 🔍 Custom Search Function
    public int searchElement(int value) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == value)
                return index;
            curr = curr.next;
            index++;
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        LL list = new LL();
        int[] arr = {1, 5, 7, 3, 8, 2, 3};

        for (int n : arr)
            list.addLast(n);

        System.out.print("Linked List: ");
        list.printList();

        int value = 7;
        int index = list.searchElement(value);

        if (index != -1)
            System.out.println("Element " + value + " found at index: " + index);
        else
            System.out.println("Element not found in list.");
    }
}
