// write your code here
import java.util.*;

public class Main{
    
    public static char[] fanyi(char[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != ' '){
                if(arr[i] < 'F'){
                    arr[i] = (char)(arr[i]+21);
                }else{
                    arr[i] = (char)(arr[i]-5);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            char[] arr = sc.nextLine().toCharArray();
            System.out.println(new String(fanyi(arr)));
        }
    }
}
