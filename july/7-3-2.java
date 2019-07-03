

import java.util.*; 
public class Main {
    public static void ipToInt(String ip){
        String[] strs = ip.split("\\.");
        long result = 0 ;
        result =          (Long.parseLong(strs[0]) << 24)
                        + (Long.parseLong(strs[1]) << 16)
                        + (Long.parseLong(strs[2]) << 8)
                        + Long.parseLong(strs[3]);
        System.out.println(result);
    }
    public static void intToIP(String ip){
        long iIp = Long.parseLong(ip);
        System.out.println(
            (iIp >> 24) + "." +
            ((iIp >> 16)&255) + "." +
            ((iIp >> 8)&255) + "." +
            ((iIp)&255)
        );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while( sc.hasNextLine()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            ipToInt(str1);
            intToIP(str2);
        }
        sc.close();
    }
}
