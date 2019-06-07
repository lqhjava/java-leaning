public static int count(Stack<Integer> s,int gread;){
        int count = 0;
        while(!s.empty()){
            if(s.pop() == gread){
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = 0;
        int gread = 0;
        while(sc.hasNext()){
            n =sc.nextInt();
            if(n == 0){
                break;
            }
            for(int i = 0; i < n;i++ ){
                st.push(sc.nextInt());
            }
            gread = sc.nextInt();
            System.out.println(count(st,gread));
        }
        
    }
