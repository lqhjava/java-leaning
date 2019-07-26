import java.util.Arrays;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0 || array == null){
            return 0;
        }
        Arrays.sort(array);
        int mid = array[array.length/2];
        int j = 0;
        for (int i : array){
             
            if (i == mid){
                j++;
            }
        }
        return j > array.length/2 ? mid : 0;
    }
}
