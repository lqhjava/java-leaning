
import java.util.*;

public class Main {
    public static void re(String a,String b){
        int x = a.length()>b.length()?a.length():b.length();
        int[] arr = new int[x+1];
        char[] a1 = a.length()>b.length()?a.toCharArray():b.toCharArray();
        char[] a2 = a.length()<=b.length()?a.toCharArray():b.toCharArray();

        int top = arr.length-1;
        for(int i = 0; i < a1.length; i++){
            if(i < a2.length) {
                arr[top] =  arr[top ]+a1[a1.length - 1 - i] - '0' + a2[a2.length - 1 - i] - '0';
            }else{
                arr[top] =  arr[top ]+a1[a1.length - 1 - i] - '0';
            }
            if(arr[top ] >= 10){
                arr[top -1] = arr[top -1] +arr[top ]/10 ;
                arr[top ] =arr[top ]%10;
                top--;
            }else{
                arr[top ] =arr[top ]%10;
                top--;
            }
        }
        String s ="";
        for (int j = arr[0]==0?1:0; j < arr.length; j++) {
            s= s + arr[j];
        }
        System.out.println(s);
    }
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String a =null;
        String b =null;
        while(sc.hasNextLine()){
            a = sc.nextLine();
            b = sc.nextLine();
            re(a,b);
        }


    }
}
