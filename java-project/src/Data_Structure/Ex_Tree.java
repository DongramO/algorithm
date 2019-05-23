package Data_Structure;

/**
 * Created by idongsu on 20/05/2019.
 */
public class Ex_Tree {
    public static void main(String args[]) {
        My_Tree mt = new My_Tree();

        mt.addNode(5);
        mt.addNode(4);
        mt.addNode(3);
        mt.addNode(1);
        mt.addNode(2);
        mt.addNode(7);
        mt.addNode(6);
        mt.addNode(8);
        mt.addNode(9);
        mt.addNode(10);

        mt.preOrder(mt.root);
    }
}

class My_Tree {
    public Node root = null;

    class Node {
        Node left;
        Node right;
        int item = -1;

        Node(int item) {
            this.item = item;
            left = null;
            right = null;
        }
    }

    void addNode(int item) {
        if( root == null ) {
            root = new Node(item);
            return;
        } else {
            addNode(item, root);
        }
    }

    void addNode(int item, Node parent) {
        if(item <= parent.item) {
            if(parent.left == null) {
                parent.left = new Node(item);
            } else {
                addNode(item, parent.left);
            }
            return;
        }

        if(item >= parent.item) {
            if(parent.right == null) {
                parent.right = new Node(item);
            } else {
                addNode(item, parent.right);
            }
            return;
        }
    }

    void preOrder(Node data) {
        if(data.item == -1) return;

        System.out.print(data.item + " => ");
        if(data.left != null) preOrder(data.left);
        if(data.right != null) preOrder(data.right);
    }

    void inOrder(Node node) {

    }

    void postOrder(Node node) {

    }
}