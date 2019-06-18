import java.util.*;

public class Main{
    public static void fight(int[] arr,int a){
        for(int i = 0;i < arr.length;i++) {
            if (arr[i] > a) {
                a = add(a, arr[i]);
            } else {
                a = a + arr[i];
            }
        }
        System.out.println(a);
    }
    public static int add(int a,int b){
        for(int i =a;i >= 1;i-- )
            if((b%i == 0) &&(a%i == 0) ){
                return a+i;
            }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i <arr.length;i++){
                arr[i] = sc.nextInt();
            }
            fight(arr,a);
        }

    }
}
