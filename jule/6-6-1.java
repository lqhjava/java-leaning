
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;
        }
        int res = (count + 2) / 3;
        System.out.println(res > 100000 ? -1 : res);
    }
