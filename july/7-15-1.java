import java.util.*;

public  class Main{
    public static boolean deal(int[] arr,int i,int length){
        if(i == 1){
            arr[0] = length;
        }
        if(i == 2){
            for(int j = 0;j < arr.length;j++){
                if(arr[j] == length){
                    arr[j] = 0;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        int n = arr[arr.length-1];
        int sum = 0;
        for (int k = 0; k < arr.length-1; k++) {
            sum = sum + arr[k];if(sum > n){
            return true;
        }
        }
       
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNext()){
            n  = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i < n;i++){
                boolean flag = deal(arr,sc.nextInt(),sc.nextInt());
               if(flag){
                   System.out.println("Yes");
               } else{
                   System.out.println("No");
               }
            }
        }
    }
    
}
