

import java.util.*;
import java.util.regex.*;
public class Main{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    while(sc.hasNext()){
      String str=sc.nextLine();
      String result=lengthCheck(str)&&contentCheck(str)&&substrCheck(str)==true?"OK":"NG";
      System.out.println(result);
    }
    sc.close();
  }
  public static boolean lengthCheck(String str){//验证是否满足条件I
    return str.length()>8;
  }
  public static boolean contentCheck(String str){//验证是否满足条件II
    String []regex={"[a-z]","[A-Z]","\\d","[^a-zA-Z0-9]"};
    int count=0;
    for(int i=0;i<4;i++){
      Pattern p=Pattern.compile(regex[i]);
      Matcher m=p.matcher(str);
      if(m.find())
        count++;
    }
    return count>=3?true:false;
  }
  public static boolean substrCheck(String str){//验证是否满足条件III
    return !str.matches(".*(...)(.*\\1).*");
  }
}
