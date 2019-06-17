import java.util.*;

public class Main{

public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String oldStr = sc.nextLine();
        String needStr = sc.nextLine();
 
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = oldStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                int count = map.get(chars[i]);
                map.put(chars[i],count+1);
            }else {
                map.put(chars[i],1);
            }
        }
 
        char[] needChars = needStr.toCharArray();
        int lastCount = 0;
        for (int i = 0; i < needChars.length; i++) {
            if (map.containsKey(needChars[i])){
                if (map.get(needChars[i])>0){
                    int count = map.get(needChars[i]);
                    map.put(needChars[i],count-1);
                }else {
                    lastCount++;
                }
            }else {
 
                lastCount++;
            }
        }
 
        if (lastCount==0){
            System.out.println("Yes "+(oldStr.length()-needStr.length()));
        }else {
            System.out.println("No "+lastCount);
        }
 
    }
}
