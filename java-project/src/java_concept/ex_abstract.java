package java_concept;

/**
 * Created by idongsu on 05/05/2019.
 */
public class ex_abstract {
    public static void main(String args[]) {
        Cats c = new Cats();
        c.cry();
    }
}

abstract class Animal {
    abstract void cry();
//    abstract void work();
}

class Cats extends Animal {
    @Override
    void cry() {
        System.out.println("ㄴㅑ아ㅏㅏㅏㅏㅏ옹");
    }
}



