import java.util.*;

public class Main{
    public static int add(int n){
        int sum =0;
        while(n > 0){
            sum = sum + n%10;
            n = n/10;
        }
       return sum;
    }
    public static int addSum(int n){
        int a = n*n;
        return add(a);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =0;
        if(sc.hasNext()){
            n = sc.nextInt();
            System.out.println(add(n)+" "+addSum(n));
        }
        
    }
}
