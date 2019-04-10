package sixshop;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by idongsu on 06/04/2019.
 */
public class example {
    // Complete the encryption function below.
    static String encryption(String s) {
        String[] word = s.split("");
        String result = "";

        int size = word.length;
        // row^2 <= L <= column^2인 row와 column을 찾아서 짤라야 한다.

        int row = (int)Math.floor(Math.sqrt(s.length()));
        int column = (int)Math.ceil(Math.sqrt(s.length()));

        for(int i=0; i<row; ++i) {
            for(int j=0; j<column; ++j) {
                result += word[j];
            }
            result += "\n";
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
