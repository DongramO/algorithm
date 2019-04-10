import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class num_6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static Stack stack;
    static public void main(String args[]) throws IOException
    {
        boolean flag = true;
        stack = new Stack();
        while(flag)
        {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            arr = new int[S];
            int[] result = new int[6];
            if(S == 0) {
                flag = false;
                break;
            }

            for(int i=0; i<S; ++i)
                arr[i] = Integer.parseInt(st.nextToken());

//            System.out.println(Arrays.toString(arr)+"\t");
            // 여섯개만 담아야 하기 때문에 S-i >= 6 상태여야 한다
            for(int i=0; S-i >= 6; ++i)
            {
                stack.push(arr[i]);
                DFS(i);
                stack.pop();
            }
            System.out.println("");
        }
    }

    static void DFS(int from)
    {
        if(stack.size() == 6)
        {
            for(int i=0; i<6; ++i)
                System.out.print(stack.get(i)+" ");
            System.out.println("");
            return;
        }

        for(int i= from+1; i<arr.length; ++i)
        {
            stack.push(arr[i]);
            DFS(i);
            stack.pop();
        }
    }

}
