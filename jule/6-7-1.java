import java.util.*;


public class Main{
    public static Stack clear(Stack<Integer> s,int n){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        for (int i = 0; i < n; i++) {
            s1.push(s.pop());
        }
        for (int j = 0; j < n; j++) {
            s2.push(s.pop());
        }

        while(true){
            if( !s2.empty()){
                s3.push(s2.pop());
            }
            if( !s1.empty()){
                s3.push(s1.pop());
            }
            if(s1.empty() && s2.empty()){
                break;
            }


        }
        return s3;

    }

    //1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
    public static void main(String[] arge){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        Stack<Integer> re = new Stack<>();
        int t = 0;
        int n = 0;
        int k = 0;
        if(sc.hasNext()){
            t = sc.nextInt();
            for(int i = 0;i < t;i++){
                n = sc.nextInt();
                k = sc.nextInt();
                for(int j = 0;j < 2*n;j++){
                    st.push(sc.nextInt());
                }
                for(int z = 0; z < k;z++){
                    st = clear(st,n);
                }
                while(!st.empty()){
                    re.push(st.pop());
                }
                for (int x = 0; x <2*n ; x++) {
                    System.out.print(re.pop());
                   // if( !((x == 2*n-1) &&(i == t-1)) ){
                        System.out.print(" ");
                    //}
                }
                System.out.println();
            }
        }
    }
}
