import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by idongsu on 2017. 10. 17..
 */
public class Comparator_prac {
    static public void main(String args[])
    {
        String a = "abcdABCD";
        String[] word = new String[a.length()];
        for(int i=0; i<a.length(); ++i)
        {
            word[i] = a.substring(i,i+1);
        }

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String a = o1.toUpperCase();
                String b = o2.toUpperCase();
                if(a.equals(b))
                {
                    char m = o1.charAt(0);
                    char n = o2.charAt(0);
                    if((int)m <(int)n) return n-m;
                    else return m-n;
                }
                else return a.compareTo(b);
            }
        });

        String result="";
        for(int i=0; i<word.length; ++i)
            result +=word[i];

        System.out.print(result);
    }
}
