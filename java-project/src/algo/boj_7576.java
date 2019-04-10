package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by idongsu on 04/04/2019.
 */
public class boj_7576 {
    static int ans = 5;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();

        char[] arr = new char[temp.length()];
        for(int i=0; i<temp.length(); ++i){
             arr[i] = temp.charAt(i);
        }

        dfs(arr, 0, arr[0]);
        System.out.print(ans);
    }

    // set 0 이면 "(",  1 이면 ")"
    public static void dfs(char[] arr, int start, char set) {
        if(start >= arr.length) return;

        if(set == arr[start]) ans += 5;
        else ans += 10;

        dfs(arr, start+1, arr[start]);

    }
}
