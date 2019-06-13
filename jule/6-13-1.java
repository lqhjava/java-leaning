import java.util.*;

public class Main{
    
    public static int tuzi(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return (tuzi(n-1) + tuzi(n-2));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n  = sc.nextInt();
            System.out.println(tuzi(n));
        }
    }
}
