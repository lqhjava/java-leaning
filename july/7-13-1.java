import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] re = new boolean[n];
        int top = 0;
        for(int i = 0;i< n;i++){
            if(s.indexOf(p[i]) != -1){
                re[top++] = true;
            }else{
                re[top++] =false;
            }
        }
        return re;
    }
}
