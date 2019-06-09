

import java.math.BigInteger;
public class Main{
    public static void main(String[] args){
        int a = 0;
        long b = 1;
        for(int i = 1;i <= 30; i++){
            a = a + 10;
            b = b + b;
        }
        System.out.print(a+" "+(b-1));
    }
}
