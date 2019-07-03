import java.util.*;

public class Main{
    public static int re(int[] arr,int x){
        for(int i =0;i <arr.length;i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    
    public  static void main(String[] args){
        Scanner sc  =new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            int x  = sc.nextInt();
            System.out.println(re(arr,x));
        }
    }
}
