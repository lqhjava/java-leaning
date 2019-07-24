

import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String[] str=new String[n];
            String result="";
            for(int i=0;i<n;i++){
                str[i]=sc.next();
            }
            Arrays.sort(str);
            String target=sc.next();
            int k=sc.nextInt();
            int count=0;//计数多少兄弟单词
            
            for(int i=0;i<n;i++){
                 
                if(isfriend(target,str[i])){
                    count=count+1;
                    if(k==count){
                        result=str[i];
                    }
                }
            }
            System.out.println(count+" ");
            if(count>=k){
                System.out.println(result);
            }
             
             
        }
 
    }
    static String sort(String str){
        char[] s=str.toCharArray();
        String result="";
        Arrays.sort(s);
        for(int i=0;i<str.length();i++){
            result=result+s[i];
             
        }
        return result;
    }
    static boolean isfriend(String s1,String s2){
        boolean b=false;
        if(s1.length()!=s2.length()){
            b=false;
        }
        if(s1.equals(s2)){
            b=false;
        }else{
            if(sort(s1).equals(sort(s2))){
                b=true;
            }
             
        }
        return b;
    }
 
}
