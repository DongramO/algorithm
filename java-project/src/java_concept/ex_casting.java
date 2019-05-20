package java_concept;

/**
 * Created by idongsu on 08/05/2019.
 */
public class ex_casting {
    static public void main(String args[]) {

        Casting ct = new Casting();
        ct.immutable();
    }

}

class Casting {
    char test = '1';
    int t = (int)test;

    String test2 = new String("1");

    public void immutable() {
        System.out.println(test2.hashCode());
        test2 = "asefasefasef";
        System.out.println(test2);
        System.out.println(test2.hashCode());
    }
}
