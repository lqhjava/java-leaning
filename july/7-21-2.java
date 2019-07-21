import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        List<List<Integer>> listall = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(listall, list, m, 1, n);
        for(List<Integer> tmp : listall) {
            String s = "";
            for(int i : tmp) {
                s += i + " ";
            }
            s = s.trim();
            System.out.println(s);
        }
    }
     
    public static void helper(List<List<Integer>> listall, List<Integer> list, int dest, int bottom, int n) {
        if(dest < 0) return;
        else if(dest == 0) {
            listall.add(new ArrayList<>(list));
            return;
        } else {
            for(int i = bottom; i <= n && i <= dest; i++) {
                list.add(i);
                helper(listall, list, dest - i, i + 1, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
