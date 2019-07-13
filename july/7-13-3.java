public static int deal(char ch){
        if(ch == 'A'){
            return 10;
        }
        if(ch == 'B'){
            return 11;
        }
        if(ch == 'C'){
            return 12;
        }
        if(ch == 'D'){
            return 13;
        }
        if(ch == 'E'){
            return 14;
        }
        if(ch == 'F'){
            return 15;
        }
        return ch-'0';
    }
    public static int toTen(String str){
        int sum = 0;
        int n = 0;
        for(int i = 0;i <str.length();i++){
            if(str.charAt(str.length()-1-i) == 'x'){
                break;
            }
            n = deal(str.charAt(str.length()-1-i));
            sum = (int)(sum + n*Math.pow(16,i));
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = null;
        if(sc.hasNext()){
            str = sc.nextLine();
            System.out.println(toTen(str));
        }
    }
