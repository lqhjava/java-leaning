import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] map = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "22233344455566677778889999"};
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Set<String> set = new TreeSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i ++ ) {
                char[] ch = sc.next().replace("-", "").toCharArray();
                for (int j = 0; j < ch.length; j ++ ) {
                    if(j == 3) sb.append("-");
                    if(Character.isLetter(ch[j])) sb.append(map[1].charAt(map[0].indexOf(ch[j])));
                    else sb.append(ch[j]);
                }
                set.add(sb.toString());
                sb.delete(0, sb.length());
            }
            for (String s:set)
                System.out.println(s);
            System.out.println();
        }
    }
}
