package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by idongsu on 18/05/2019.
 */
public class Ex_queue {
    public static void main(String args[]) {
        Queue<String> queue = new LinkedList<>();

        My_Queue my = new My_Queue();

        my.offer("1");
        my.offer("2");
        my.offer("3");
        my.offer("4");
        my.offer("5");
        my.offer("6");

        while(!my.isEmpty()) {
            my.remove();
        }
    }
}

class My_Queue {

    public class Node {
        Object item;
        Node next;

        Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    My_Queue() {
        front = null;
        rear = null;
    }

    void offer(Object item) {
        Node node = new Node(item);
        if(front == null) {
            front = rear = node;
            System.out.println("add item is : " + item);
            return;

        }

        rear.next = node;
        rear = node;
        System.out.println("add item is : " + item);
    }

    void remove() {
        Node node = front;
        front = node.next;

        System.out.println("remove item is : " + node.item);
    }

    Object peek() {
        if(front == null) throw new Error("Queue item is Empty");
        return front.item;
    }

    boolean isEmpty() {
        return front == null || rear == null ? true : false;
    }
}
