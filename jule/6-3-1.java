import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        String a = null ;
        if(sc.hasNextLine()){
            n = sc.nextInt();
            a = sc.next();
        }
        char[][] arr = new char[(n+1)/2][n];
        for(int i = 0;i < (n+1)/2;i++){
            for (int j =0;j < n;j++){
                if(i == 0 || i == ((n+1)/2-1) ){
                    arr[i][j] = a.charAt(0);
                    System.out.print(arr[i][j]);
                }else if(j == 0 || j== n-1){
                    arr[i][j] = a.charAt(0);
                    System.out.print(arr[i][j]);
                }else{
                    arr[i][j] =' ';
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }


    }
}
