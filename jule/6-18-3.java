

import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
 
     public static void main(String[] args)throws Exception{
         Scanner s = new Scanner(System.in);
         int[] data = new int[2];
         do{
         data[0] = s.nextInt();
         data[1] = s.nextInt();
         ArrayList<Integer> array = new ArrayList<Integer>();
         for(int i = 0; i < data[0]; i ++){
             array.add(s.nextInt());
         }
         int num = 0;
         char a ;
         int b,c;
         while(num < data[1]){
             a = s.next().charAt(0);
             b = s.nextInt();
             c = s.nextInt();
             if('Q' == a){
                 int start, end;
                 if(b <= c){
                 start = b - 1;
                 end = c - 1;
                 }else{
                     start = c - 1;
                     end = b - 1;
                 }
                 int max = array.get(start);
                 for(int index = start; index <= end; index ++){
                     if(array.get(index) >= max)
                         max = array.get(index);
                 }
                 //result.add(max);
                 System.out.println(max);
             }
             if('U' == a){
                 int index1 = b - 1;
                 int newValue = c;
                 array.set(index1, newValue);
             }
             s.nextLine();
             num ++;
         }
         }while(s.hasNext());
         s.close();
              
    }
}
