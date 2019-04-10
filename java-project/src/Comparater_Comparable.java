import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by idongsu on 2017. 10. 17..
 */
public class Comparater_Comparable {
    static public void main(String args[])
    {
        Fruit a = new Fruit("apple","1000");
        Fruit b = new Fruit("Grape","1000");
        Fruit c = new Fruit("orange","1000");
        Fruit d = new Fruit("Banana","1000");
        Fruit[] Flist = new Fruit[4];
        Flist[0] = a; Flist[1] = b; Flist[2] = c; Flist[3] = d;

        Arrays.sort(Flist, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {

                String name1 = o1.getName().toUpperCase();
                String name2 = o2.getName().toUpperCase();
                return name1.compareTo(name2);
            }
        });

        for(int i=0; i<Flist.length; ++i)
            System.out.print(Flist[i].getName()+"\t");
    }
}
class Fruit implements Comparable<Fruit>{
    String name;
    String price;

    Fruit(String name, String price)
    {
        this.name = name;
        this.price = price;
    }
    String getName()
    {
        return this.name;
    }

    @Override
    public int compareTo(Fruit o) {
        return 0;
    }
}
