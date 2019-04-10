import java.io.BufferedReader;
import java.io.InputStreamReader;

public class num_10775 {
    static public void main(String args[]) throws  Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int[] gate = new int[g+1];
        int dock=0, flag=0;
        int count =0;
        for(int i=0; i<p; ++i )
        {
            dock = Integer.parseInt(br.readLine());
            flag =0;
            for(int j=dock; j>0; --j)
            {
                if(gate[j] == 0) {
                    gate[j] = 1;
                    count++;
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                break;
        }
        System.out.print(count);
    }

}
