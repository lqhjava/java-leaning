import java.util.*;
public class Day {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] arr = new int[len1+1][len2+1];
        for(int i = 0;i <= len1;i++ ){
            arr[i][0] = i;
        }
        for(int i = 0;i <= len2; i++){
            arr[0][i] = i;
        }

        for(int i =1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                if( word1.charAt(i-1) == word2.charAt(j-1)){
                    arr[i][j] = 1 + Math.min(arr[i][j-1],arr[i-1][j]);
                    arr[i][j] = Math.min(arr[i][j],arr[i-1][j-1]);
                }else{
                    arr[i][j] =  1+Math.min(arr[i][j-1],arr[i-1][j]);
                    arr[i][j] = Math.min(arr[i][j],1+arr[i-1][j-1]);
                }
            }
        }
        return arr[len1][len2];

    }

    public static void main(String[] args){
        String str1 = "sea";
        String str2 = "eat";
        System.out.println(minDistance(str1,str2));


    }
}
