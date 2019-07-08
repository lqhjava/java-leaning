import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;
public class Main {
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            BigInteger[] a = new BigInteger[n];
            for(int i = 0; i < n; i++){
                a[i] = input.nextBigInteger();
            }
            Arrays.sort(a);
            for(int i = 0; i < n; i++){
                System.out.println(a[i]);
            }
        }
    }
}
