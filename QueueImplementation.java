class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedListQueue {
    Node front, rear;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued: " + front.data);
        front = front.next;
        if (front == null)
            rear = null;
        }
        void peek() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Front Element:" + front.data);
        }
        void findMinMax() {
            if (front == null) return;
            int min = front.data;
            int max = front.data;
            Node temp = front;
            while (temp != null) {
                if (temp.data < min) min = temp.data;
                if (temp.data > max) max = temp.data;
                temp = temp.next;
            }
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        }
    }
    class TestQueue {
        public static void main(String[] args) {
            LinkedListQueue queue = new LinkedListQueue();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.peek();
            queue.dequeue();
            queue.findMinMax();
        }
    }