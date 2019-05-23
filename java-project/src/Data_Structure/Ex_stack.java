package Data_Structure;

import java.io.IOException;

/**
 * Created by idongsu on 18/05/2019.
 */
public class Ex_stack {
    public static void main(String args[]) throws IOException {
        My_stack my_stack = new My_stack();

        my_stack.push("hello");
        my_stack.push("hello1");
        my_stack.push("hello2");
        my_stack.push("hello3");
        my_stack.push("hello4");
        my_stack.push("hello5");
        my_stack.push("hello6");
        my_stack.push("hello7");

        my_stack.peek();

        while(!my_stack.isEmpty()) {
            my_stack.pop();
        }
    }
}

class My_stack {
    Node top;

    public class Node {
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    void push(Object data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    Object pop() {
        // 맨 위의 요소를 꺼낸 후 제거한다.
        if(top.next == null) throw new Error("Empty elements");

        Object data = top.data;
        top = top.next;
        System.out.println("Poped data is : "+ data);
        return data;
    }

    Object peek() {
        if(top.next == null) throw new Error("Empty elements");
        System.out.println("Peeped data is : "+ top.data);
        return top.data;
    }

    boolean isEmpty() {
        return top.next == null ? true : false;
    }

    int size() {
        int cnt = 0;
        while(top.next != null) cnt++;
        return cnt;
    }
}
