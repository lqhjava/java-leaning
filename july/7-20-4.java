

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String needEncry = sc.nextLine();
            String needDecry = sc.nextLine();
            char[] enchar = needEncry.toCharArray();
            StringBuffer sbe = new StringBuffer();
            for(int i=0; i<enchar.length; i++) {
                if(enchar[i]=='z') {
                    sbe.append("A");
                } else if(enchar[i]>='a' && enchar[i]<'z') {
                    sbe.append(String.valueOf((char)(enchar[i]-31)));
                } else if(enchar[i]=='Z') {
                    sbe.append("a");
                } else if(enchar[i]>='A' && enchar[i]<'Z') {
                    sbe.append(String.valueOf((char)(enchar[i]+33)));
                } else if(enchar[i]=='9') {
                    sbe.append("0");
                } else if(enchar[i]>='0' && enchar[i]<'9') {
                    sbe.append(Integer.valueOf(String.valueOf(enchar[i]))+1);
                }
            }
            System.out.println(sbe.toString());
            char[] dechar = needDecry.toCharArray();
            StringBuffer sbd = new StringBuffer();
            for(int j=0; j<dechar.length; j++) {
                if(dechar[j]=='a') {
                    sbd.append("Z");
                } else if(dechar[j]>'a' && dechar[j]<='z') {
                    sbd.append(String.valueOf((char)(dechar[j]-33)));
                } else if(dechar[j]=='A') {
                    sbd.append("z");
                } else if(dechar[j]>'A' && dechar[j]<='Z') {
                    sbd.append(String.valueOf((char)(dechar[j]+31)));
                } else if(dechar[j]=='0') {
                    sbd.append("9");
                } else if(dechar[j]>'0' && dechar[j]<='9') {
                    sbd.append(Integer.valueOf(String.valueOf(dechar[j]))-1);
                }
            }
            System.out.println(sbd.toString());
        }
    }
}
