// write your code here
import java.util.*;

public class Main{
    
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String boxA=sc.next();
            String boxB=sc.next();
            HashMap<String,Integer> hashMapBoxA=new HashMap<String,Integer>();
            HashMap<String,Integer> hashMapBoxB=new HashMap<String,Integer>();
            for(int i=0;i<boxA.length();i++){
                if(hashMapBoxA.containsKey(boxA.charAt(i)+"")){
                    hashMapBoxA.put(boxA.charAt(i)+"",hashMapBoxA.get(boxA.charAt(i)+"")+1);
                }else{
                    hashMapBoxA.put(boxA.charAt(i)+"",1);
                }
            }
 
            for(int i=0;i<boxB.length();i++){
                if(hashMapBoxB.containsKey(boxB.charAt(i)+"")){
                    hashMapBoxB.put(boxB.charAt(i)+"",hashMapBoxB.get(boxB.charAt(i)+"")+1);
                }else{
                    hashMapBoxB.put(boxB.charAt(i)+"",1);
                }
            }
 
            int flag=0;
            for(String key:hashMapBoxB.keySet()){
                if(!hashMapBoxA.containsKey(key)){
                    flag=1;
                    break;
                }else{
                    if(hashMapBoxA.get(key)<hashMapBoxB.get(key)){
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==1){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
