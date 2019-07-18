import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        if(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            for(int i =0; i<str2.length();i++){
               str1 = str1.replaceAll(String.valueOf(str2.charAt(i)),"") ;
            }
            System.out.println(str1);
        }
    }
}
