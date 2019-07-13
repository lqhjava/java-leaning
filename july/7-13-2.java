import java.util.*;

public class Main
{
    public static void main(String... as)
    {
        Scanner sc = new Scanner(System.in);
        int[] times = new int[26];
        while (sc.hasNextLine())
        {
            Arrays.fill(times, 0);
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++)
                if (Character.isUpperCase(s.charAt(i)))
                    times[s.charAt(i) - 'A']++;
            for (int i = 0; i < 26; i++)
                System.out.println((char) (i + 'A') + ":" + times[i]);
        }
        sc.close();
    }
     
}
