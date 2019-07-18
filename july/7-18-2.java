import java.util.*;

public class Main{
    public static boolean isHuiWen(String str){
        for(int i = 0;i < str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            String str = sc.nextLine();
            String str1 = null;
            for(int i =0 ;i <str.length();i++){
                if(i == 0){
                    str1 = str.substring(1,str.length()) ;
                }else if(i == str.length()-1){
                    str1 = str.substring(0,str.length()-1) ;
                }else{
                    str1 = str.substring(0,i)+str.substring(i+1,str.length());
                }
                if(isHuiWen(str1)){
                    System.out.println("YES") ;
                    break;
                }
                if(i == str.length()-1){
                    System.out.println("NO");
                }
            }
        }
    }
}
