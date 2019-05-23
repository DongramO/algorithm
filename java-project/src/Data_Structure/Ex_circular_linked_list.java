package Data_Structure;

/**
 * Created by idongsu on 20/05/2019.
 */
public class Ex_circular_linked_list {
    public static void main(String args[]) {

    }
}

/*
    연결리스트에 기본 적으로 들어가는 메소드의 범위를 어떻게 잡을지에 따라 달라지겠지만
    기본적으로 중간삽입, 인덱스 데이터 검색, 데이터 추출을 갖추고 있는게 좋을 꺼 같다.
    stack과 queue 같은 경우에는 동작 자체가 전부 정해져 있으니까.
    제외되는 메소드들이 있을꺼고..
*/

class My_Circular_Lisked_List {
    private Node head;
    private Node tail;
    private int size;
    private class Node {

        private Node next;
        private Object item;

        Node(Object item) {
            this.item = item;
            next = null;
        }
    }

    void add(Object item) {
        if(head == null) {
            Node newNode = new Node(item);
            head = tail = newNode;
            head.next = newNode;
            size++;
        } else {
            Node newNode = new Node(item);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    void remove() {

    }

    void getNode() {

    }

    void getData() {

    }

    boolean peek() {
        return true;
    }

    boolean isEmpty() {
        return true;
    }
}
