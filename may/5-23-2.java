public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[] a =new char[1024];
    char[] b =new char[1024];
    char[] c = new char[1024];
    String[] str = new String[1024];
    if(sc.hasNextLine()){
        str = sc.nextLine().split(" ");
    }

    String str1 =""  ;
    for (int i = 0; i < str.length-1; i++) {
        if(i == 0){
            str1 =  str[i];
        }else {
            str1 = str1 + " " + str[i];
        }
    }
    a =str1.toCharArray();
    b = str[str.length-1].toCharArray();
    int top = 0;
    for(int i = 0; i< a.length;i++){
        for(int j = 0; j < b.length; j++){
            if(a[i] == b[j]){
                break;
            }
            if(j == b.length-1){
                c[top] = a[i];
                top++;
            }
        }

    }
    for (int i = 0; i < top; i++) {

        System.out.print(c[i]);
    }
    //System.out.println(".");
}
