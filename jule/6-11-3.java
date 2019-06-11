import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
         Arrays.sort(gifts);
        int count = 1;
        for(int i =0;i < gifts.length-1;i++){
            if(gifts[i] == gifts[gifts.length/2]){
                count++;
            }
            if(count >= (n+1)/2){
                return gifts[i];
            }
        }
        return 0;
    }
}
