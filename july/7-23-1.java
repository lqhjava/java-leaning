// write your code here
import java.util.*;

public class Main{
   public static String deal(String[] arr){
        String re = arr[0];
        for(int i = 1; i<arr.length;i++){
            re = re+(char)(arr[i].charAt(0)-'a'+'A');
            for(int j = 1;j <arr[i].length();j++){
                re = re + arr[i].charAt(j);
            }
        }
        return re;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = null;
        while(sc.hasNext()){
            arr = sc.nextLine().split("_");
            System.out.println(deal(arr));
        }
    }
}
