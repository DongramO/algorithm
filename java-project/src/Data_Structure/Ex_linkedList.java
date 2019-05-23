package Data_Structure;

/**
 * Created by idongsu on 18/05/2019.
 */
public class Ex_linkedList {
    public static void main(String args[]) {
        Linkedlist list = new Linkedlist();

        list.add("first");
        list.add("second");
        list.add("third");
        list.add(1, "forth");
        list.add(3, "fifth");
        list.remove();

        for(int i=0; i<list.size; ++i) {
            System.out.println("index: "+ i +" " +list.getData(i));
        }

    }
}

class Linkedlist {

    Node head;
    Node tail;
    int size;

    Linkedlist() {
        head = new Node(null);
        size = 0;
    }

    private class Node {
        private String data;
        private Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

    }

    void firstAdd(String data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    // 맨 뒤에 추가
    void add(String data) {
        add(size, data);
    }

    void add(int index, String data) {

        if(index == 0 ) {
            firstAdd(data);
            return;
        }

        Node newNode = new Node(data);
        Node priv_node = getNode(index-1);

        newNode.next = priv_node.next;
        priv_node.next = newNode;

        size++;
    }

    void remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        } else if(index == 0) {
            head.next = null;
            size--;
            return;
        }

        Node priv_node = getNode(index-1);
        priv_node.next = priv_node.next.next;
        size--;
    }

    // 마지막 노드 삭제
    void remove() {
        if(size == 0){
            throw new IndexOutOfBoundsException("Size : " + size);
        }

        Node priv_node = getNode(size-2);
        priv_node.next = priv_node.next.next;
        size--;
    }


    Node getNode(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }
        // index == 0
        Node node = head.next;

        for(int i=0; i <index; ++i) {
            node = node.next;
        }

        return node;
    }

    String getData(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        Node node = head.next;

        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node.data;
    }
}