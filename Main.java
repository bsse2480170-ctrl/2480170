class ArrayQueue{
    int[] queue;
    int front, rear, size;
    ArrayQueue(int capacity){
        queue=new int[capacity];
        front=0;
        rear=-1;
        size=0;
    }
    void resize(){
        int newCapacity=queue.length*2;
        int[] newQueue=new int[newCapacity];
        for(int i=0; i<size; i++){
            newQueue[i]=queue[front+i];
        }
        queue=newQueue;
        front=0;
        rear=size-1;
        System.out.println("Array resized to size: "+newCapacity);
    }
    void enqueue(int data){
        if(size==queue.length){
            resize();
        }
        rear++;
        queue[rear]=data;
        size++;
    }
    void  dequeue(){
        if(size==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued:"+queue[rear]);
        front++;
        size--;
    }
    void peek(){
        if(size==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front:"+queue[front]);
    }
    void display(){
        System.out.println("Queue:");
        for(int i=0; i<size; i++){
            System.out.println(queue[front+i]+" ");
        }
        System.out.println();
    }
    void findMinMax(){
        if(size==0) return ;
        int min =queue[front];
        int max=queue[front];
        for(int i=0; i<size; i++){
            int val=queue[front+i];
            if(val<min) min=val;
            if(val>max) max=val;
        }
        System.out.println("Min:"+min);
        System.out.println("Max:"+max);
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
        aq.enqueue(10);
        aq.enqueue(20);
        aq.enqueue(30);
        aq.display();
        aq.enqueue(40);
        aq.display();
        aq.peek();
        aq.dequeue();
        aq.display();
        aq.findMinMax();
    }
}