public static void canDrink(int a){
        int count = 0;
        if(a == 1 || a== 2){
            System.out.println(0);
            return ;
        }
        while(a > 2){
            count =count + a/3;
            a = a/3 + a%3;
        }
        if(a == 2){
            System.out.println(count+1);
        }else{
            System.out.println(count);
        }
    }
    public static void  main(String[] ars){
        Scanner sc = new Scanner(System.in);
        int[] a= new int[10];
        int j = 0;
        for (int z = 0; z < 10; z++) {
            if(sc.hasNextInt()){
                a[z] = sc.nextInt();
            }
            if(a[z] == 0){
                break;
            }
        }
        for(int i = 0; i< a.length;i++){
            if(a[i] == 0){
                break;
            }
            canDrink(a[i]);
        }
    }
