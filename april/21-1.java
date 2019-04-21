package PaiXu;

public class TestDemo1 {

    public static void insertSort(int[] array){
        if(array.length == 0){
            throw new UnsupportedOperationException("没有数据");
        }
        for (int i = 1; i < array.length-1; i++) {
            int j = i-1;
            int tem = array[i];
            while(array[j] > tem){
                array[j+1] = array[j];
                j--;
                if(j<0){
                    array[0] = tem;
                    break;
                }
            }
            array[j+1] = tem;
        }
    }

    public static void shell(int[] arr,int grp){
        for (int i = grp; i < arr.length; i++) {
            int j = i-grp;
            int tem = arr[i];
            while(arr[j] > tem){
                arr[j+grp] = arr[j];
                j = j-grp;
                if(j<i-grp){
                    arr[i-grp] = tem;
                    break;
                }
            }
            arr[j+grp] = tem;
        }
    }
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,7,1,8,9};
        shellSort(arr);
        //System.out.println(arr.length);
        for (int i :arr) {
            System.out.print(i+"  ");
        }
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]+"  ");
//        }
        System.out.println();
    }
}
