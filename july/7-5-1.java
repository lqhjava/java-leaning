import java.util.*;

public class Main{
    
    public static void isShouXin(int n){
        int sum = n*n;
        while(n > 0){
            if((n%10) != (sum%10)){
                System.out.println("No!");
                return;
            }
            sum =sum/10;
            n = n/10;
        }
        System.out.println("Yes!");
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            isShouXin(n);
        }
        
    }
}
