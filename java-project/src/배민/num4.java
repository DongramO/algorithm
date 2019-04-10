package 배민;

/**
 * Created by idongsu on 17/03/2019.
 */
public class num4
{
    public static void main(String[] args) {
        int[] pobi = {131,132};
        int[] crong = {211, 212};

        System.out.print(solve(pobi, crong));
    }
    // 포비 1 크롱 2 무승부 0 예외 -1
    static int solve(int[] pobi, int [] crong) {
        int result = 0;
        if(pobi[0] > pobi[1] || Math.abs(pobi[0] - pobi[1]) > 1 || crong[0] > crong[1] || Math.abs(crong[0] - crong[1]) > 1) {
            return -1;
        }

        int p_odd = compare(pobi[0]);
        int p_even = compare(pobi[1]);
        int c_odd = compare(crong[0]);
        int c_even = compare(crong[1]);

        int p_result = 0;
        int c_result = 0;

        if(p_odd > p_even) p_result = p_odd;
        else p_result = p_even;

        if(c_odd > c_even) c_result = c_odd;
        else c_result = c_even;

        if(p_result > c_result) return 1;
        else if(c_result > p_result) return 2;
        else if(c_result == p_result) return 0;
        else return -1;
    }

    static int sum(String page) {
        char[] num = new char[page.length()];
        int result = 0;
        for (int i = 0; i < page.length(); ++i) {
            char k  = page.charAt(i);
            result += Integer.parseInt(k+"");
        }
        return result;
    }

    static int multiple(String page) {
        char[] num = new char[page.length()];
        int result = 1;
        for (int i = 0; i < page.length(); ++i) {
            char k  = page.charAt(i);
            result *= Integer.parseInt(k+"");
        }
        return result;
    }

    static int compare(int num) {
        int result = 0;
        String numTostring = String.valueOf(num);

        int sumResult = sum(numTostring);
        int mulResult = multiple(numTostring);

        if(sumResult > mulResult) return sumResult;
        else return mulResult;
    }
}
