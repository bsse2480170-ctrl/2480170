class DoublyLinkedList {

    Node head;
    Node tail;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void deleteBeforeValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.prev == null) {
            System.out.println("No previous node exists");
            return;
        }

        System.out.println(temp.prev.data + " deleted.");

        if (temp.prev.prev == null) {
            head = temp;
            temp.prev = null;
            return;
        }

        temp.prev = temp.prev.prev;
        temp.prev.next = temp;
    }

    public void printForward() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.printForward();

        list.deleteBeforeValue(30);
        list.printForward();

        list.deleteBeforeValue(10);
        list.deleteBeforeValue(50);
    }
}
