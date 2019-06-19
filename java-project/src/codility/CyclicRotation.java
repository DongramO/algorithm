package codility;

/**
 * Created by idongsu on 19/06/2019.
 */
public class CyclicRotation {

    class Solution {
        public int[] solution(int[] A, int K) {

            int rotate = 0;

            if(A.length != 0) {
                rotate = K % A.length;
            }


            for(int i=0; i<rotate; ++i) {

                int temp = A[A.length-1];

                for(int j=A.length-1; j>0; --j) {
                    A[j] = A[j-1];
                }

                A[0] = temp;
            }
            return A;
        }
    }
}
