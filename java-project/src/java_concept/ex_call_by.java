package java_concept;

/**
 * Created by idongsu on 11/05/2019.
 */
public class ex_call_by  {
    public static void main(String args[]) {

        Person p = new Person("doy");

        assignNewPerson(p);
        System.out.println(p); // name is doy

        changeName(p);
        System.out.println(p); // name is hee
    }

    public static void assignNewPerson(Person p) {
        p = new Person("hee");
        p.getName();
    }

    public static void changeName(Person p) {
        p.setName("hee");
    }
}

class Person {

    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println("getName : " + this.name);
    }
    public String toString() {
        return "name is " + this.name;
    }
}

