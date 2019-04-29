package com.lqh.main;

public class Sort {

    //插入排序
    public static void sort1(int[] elem){

        for (int i = 1; i < elem.length; i++) {
            int tem = elem[i];
            tem = elem[i];
            int j = 0;
            for ( j = i-1; j >= 0; j--) {
                if(elem[j] > tem){
                    elem[j+1] = elem[j];
                }else{
                    break;
                }
            }
            elem[j+1] = tem;
        }
    }

    //选择排序
    //时间复杂度 O(N^2)
    //不稳定
    public static void sort2(int[] elem){
        for (int i = 0; i < elem.length; i++) {
            int tem =0;
            for (int j = i+1; j < elem.length ; j++) {
                if(elem[j] < elem[i]){
                    tem = elem[i];
                    elem[i] = elem[j];
                    elem[j] = tem;
                }
            }
        }
    }

    /*
    * 堆排序
    * 时间复杂度O(nlogn)
    * 不稳定排序
    */
    public static void adjust(int[] elem, int start, int end){
      //调整一个树
        int tem = elem[start];
        for (int i = 2*start+1; i <= end ; i=2*i+1) {
            //判断是否有左右孩子，
            if(i < end && elem[i] < elem[i+1]){
                i++;
            }

            if(elem[i] > tem){
                elem[start] = elem[i];
                start = i;
            }else if(elem[i] < tem){
                //elem[start] = tem;
                break;
            }
        }
        elem[start] = tem;

    }
    public static void sort3(int[] elem){
        for (int i = (elem.length-1-1); i >= 0; i--) {
            adjust(elem,i,elem.length-1);
        }
        // 走完后，树变为大根堆
        for (int j = 0; j < elem.length-1; j++) {
            int tem = elem[0];
            elem[0] = elem[elem.length-1-j];
            elem[elem.length-1-j] = tem;

            adjust(elem,0,elem.length-1-j-1);
        }
    }

    /*
    * 交换排序
    */
    public static void sort4(int[] elem){


    }
    /*
    *快速排序
    */
    public static int quickSort(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high) {


            while (low < high && array[high] >= tmp) {
                high--;
            }
            if (low == high) {
                //array[low] = tmp;
                break;
            } else {
                array[low] = array[high];
            }

            while (low < high && array[low] <= tmp) {
                low++;
            }
            if (low == high) {
                //array[low] = tmp;
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
    public static void quick(int[] array,int low,int high){
        if(low == high){
            return;
        }
        //三次取中
        takeThreeNumber(array,low,high);
        int par = quickSort(array,low,high);
        //递归左边  保证左边有两个数据以上
        if(par > low +1){
            quick(array,low,par-1);
        }
        //递归右边  保证右边有两个数据以上
        if(par < high-1){
            quick(array,par+1,high);
        }
    }
    public static void sort5(int[] array){
        quick(array,0,array.length-1);
    }
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
    public static void takeThreeNumber(int[] array,int low,int high){

        int mid = (low + high)>>>1;//无符号右移
        if(array[mid] > array[low]){
            swap(array,mid,low);
        }
        if(array[mid] > array[high]){
            swap(array,mid,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }

    /*
    *
    */




    public static void main(String[] args) {
        int[] a = {2,5,6,7,3,1,8};
        sort5(a);
        for (int i:a
             ) {
            System.out.print(i+"   ");
        }
    }
}
