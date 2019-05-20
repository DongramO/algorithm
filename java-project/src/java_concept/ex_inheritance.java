package java_concept;

/**
 * Created by idongsu on 05/05/2019.
 */
public class ex_inheritance {

    static public void main(String args[]) {
        Fathers father = new Fathers();
        Mothers mother = new Mothers();

        mother.display();
    }
}

class Parent_inherit {
    int a;
    Parent_inherit(int n) {
        this.a = n;
    }
}
class Fathers extends Parent_inherit{
    int b;
    Fathers() {
        super(10);
        this.b = 20;
    }
}

class Mothers extends Fathers {
    int b;
    Mothers() {
        super();
        this.b = 30;
    }

    void display() {
        System.out.println(a);
        System.out.println(super.b);
        System.out.println(this.b);
    }
}

