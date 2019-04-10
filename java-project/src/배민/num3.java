package 배민;

/**
 * Created by idongsu on 16/03/2019.
 */
public class num3 {
    static char[] big= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
    static char[] small = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };

    public static void main(String args[]) {
        System.out.println(solve("I love you"));
    }

    static String solve(String word) {
        char[] wording = new char [word.length()];
        for(int i=0; i < word.length(); ++i) {
            wording[i] = word.charAt(i);
        }

        String result = "";

        char[] big_set = new char[big.length];
        char[] small_set = new char[big.length];

        for(int i = 0; i < big.length; ++i) {
           big_set[i] = big[big.length-1 - i];
           small_set[i] = small[small.length-1 - i];
        }

        int index = 0;
        while(index < wording.length ) {
            int k = (int) wording[index];
            if( k >= 65 && k <= 90) {
                int t = k-65;
                result += big_set[t];
            } else if( k >= 97 && k<= 122) {
                int t = k-97;
                result += small_set[t];
            } else {
                result += wording[index];
            }
            index++;
        }
        return result;
    }
}


