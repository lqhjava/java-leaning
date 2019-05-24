public static int count(int[] arr,int n, int v){
        //返回条件 拿到最后一个了 够了  或者这个数比v大了
        if(v == 0){
            //那够了
            return 1;
        }else if(n == 0){
            //拿到最后一件了
            if (arr[n] == v) {
                //拿了这一件
                return 1;
            }else {
                //没拿着一件
                return 0;
            }

        }else if( arr[n] > v){
            //这一件比 v大 不拿 直接到下一件
            return count(arr,n-1,v);
        }else{
            //拿了这一件 或者不安这一件
            return count(arr,n-1,v-arr[n])+count(arr,n-1,v);
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNext()){
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(count(arr,n-1,40));


    }
