import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            for(int i =arr.length-1 ;i >= 0;i--){
                if(i == 0){
                    System.out.println(arr[i]);
                }else{
                    System.out.print(arr[i]+" ");
                }
            }
        }
    }
}
