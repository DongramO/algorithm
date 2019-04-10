package sixshop;

import java.util.List;

/**
 * Created by idongsu on 06/04/2019.
 */
public class num_3 {
    public static void main(String args[]) {

    }

    public static int minPower(List<Integer> p) {
        int index = 1;
        while(true) {

            for(int i=0; i<p.size(); ++i) {
                int temp = p.get(i);

                if(temp < 0) {
                    index += temp;
                } else if(temp >0) {
                    index -= temp;
                }

                if(index > 0) {
                    return index;
                }
            }
            index++;
        }
    }

}
