import java.util.*;

public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] re = null;
        if(n == 1){
            return re = new String[]{"0","1"};
        }else{
            String[] str = getGray(n-1);
            re = new String[2*str.length];
            for(int i = 0;i<re.length/2;i++){
                re[i] = "0"+str[i];
                re[re.length-1-i] = "1"+str[i];
            }
        }
        return re;
    }
}
