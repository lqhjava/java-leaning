import java.util.*;

public class Main{
    public  static int deal(int[] arr){
       
            int max = arr[0];
            int sum = arr[0];
            for(int i=1;i<arr.length;i++){
                if(sum>=0){
                    sum += arr[i];
                }else{
                    sum = arr[i];
                }
                if(sum>max)
                {
                    max=sum;
                }
            }
        return max;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ;i < n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(deal(arr));
        }
    }
}
