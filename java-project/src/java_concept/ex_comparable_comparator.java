package java_concept;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by idongsu on 09/05/2019.
 */
public class ex_comparable_comparator {
    public static void main(String args[]) {
        Vehicle car01 = new Vehicle("아반떼", 2016, "노란색");
        Vehicle car02 = new Vehicle("소나타", 2017, "흰색");

        System.out.println(car01.compareTo(car02));

        Vehicle2 car03 = new Vehicle2("아반떼", 2016, "노란색");
        Vehicle2 car04 = new Vehicle2("소나타", 2017, "흰색");

    }
}

class Vehicle implements Comparable<Vehicle> {
    private String modelName;
    private int modelYear;
    private String color;

    Vehicle(String mn, int my, String c) {
        this.modelName = mn;
        this.modelYear = my;
        this.color = c;
    }

    public String getModel() {
        return this.modelYear+ "식" + this.modelName + " " + this.color;
    }

    public int compareTo(Vehicle obj) {
        if(this.modelYear == obj.modelYear) {
            return 0;
        } else if(this.modelYear < obj.modelYear) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Vehicle2 implements Comparator<Vehicle2> {
    private String modelName;
    private int modelYear;
    private String color;

    Vehicle2(String mn, int my, String c) {
        this.modelName = mn;
        this.modelYear = my;
        this.color = c;
    }

    public String getModel() {
        return this.modelYear+ "식" + this.modelName + " " + this.color;
    }

    @Override
    public int compare(Vehicle2 o1, Vehicle2 o2) {
        return o1.modelYear - o2.modelYear;
    }
}


