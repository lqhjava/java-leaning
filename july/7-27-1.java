import java.util.*;

public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        // write code here
       int max = 0;
        int pos = 0;
        for(int i = 0; i < n; i++)
            if(max < A[i]){
            max = A[i];
            pos = i;
        }
        if(pos == 0)
            return A[0] - A[n-1];
        if(pos == n-1)
            return A[n-1] - A[0];
        int left = (A[pos] - A[0]);
        int right = (A[pos] - A[n-1]);
        return left > right ?  left: right;    
    }
    
}
