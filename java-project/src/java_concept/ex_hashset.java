package java_concept;

import java.util.HashSet;

/**
 * Created by idongsu on 09/05/2019.
 */
public class ex_hashset {

    public static void main(String args[]) {
        HashSet<String> hs01 = new HashSet<>();
        HashSet<String> hs02 = new HashSet<>();

        hs01.add("홍길동");
        hs01.add("이순신");
        System.out.println(hs01.add("임꺽정"));
        System.out.println(hs01.add("임꺽정"));

        for(String e : hs01) {
            System.out.println(e);
        }


        HashSet<Animals> hs = new HashSet<>();

        hs.add(new Animals("고양이", "육지"));
        hs.add(new Animals("고양이", "육지"));
        hs.add(new Animals("고양이", "육지"));

        System.out.println(hs.size());

    }
}

class Animals {
    String species;
    String habitat;

    Animals(String species, String habitat) {
        this.species = species;
        this.habitat = habitat;
    }

    public int hashCode() { return (species + habitat).hashCode(); }

    public boolean equals(Object obj) {
        if(obj instanceof Animals) {
            Animals temp = (Animals)obj;
            return species.equals(temp.species) && habitat.equals(temp.habitat);
        } else {
            return false;
        }
    }
}


