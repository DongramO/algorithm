package codility;


public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int temp = 0;

        for(int i=0; i<A.length; ++i) {
            temp = temp ^ A[i];
        }

        return temp;
    }
}

