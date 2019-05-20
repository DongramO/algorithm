package algo;

/**
 * Created by idongsu on 20/05/2019.
 */
public class Ex_circular_Queue {
    public static void main(String args[]) {
        My_Circular my_circular = new My_Circular(6);

        my_circular.Enqueue(1);
        my_circular.Enqueue(2);
        my_circular.Enqueue(3);
        my_circular.Enqueue(4);
        my_circular.Enqueue(5);
        my_circular.Enqueue(6);
        my_circular.Enqueue(7);
        my_circular.Enqueue(8);
        my_circular.Enqueue(9);

        while(!my_circular.isEmpty()) {
            System.out.println(my_circular.Dequeue());
        }
    }
}

class My_Circular {
    private int front = 0;
    private int rear = 0;
    private int[] data;
    private int max_size;

    My_Circular(int max_size) {
        this.max_size = max_size;
        data = new int[max_size];
    }

    void Enqueue(int item) {
        if(isFull()) {
            throw new Error("Circluar Queue is Pulled");
        } else {
            System.out.println("Enqueue item" + item);
            rear = (rear+1) % max_size;
            data[rear] = item;
        }
    }

    int Dequeue() {
        if(isEmpty()) throw new Error("Queue is Empty");

        front = (front +1 ) % max_size;

        return data[front];
    }

    boolean isEmpty() {
        return front == rear ? true : false;
    }

    boolean isFull() {
        return ( (rear+1) % max_size == front ) ? true : false;
    }
}