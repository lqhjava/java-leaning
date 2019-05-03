package com.lqh.main;
import java.util.Arrays;
import java.util.Random;


public class TestSort {

    /*
    1.插入排序
     */
    public static void insertSort(int[] array){

        long start = System.nanoTime();

        for (int i = 1; i < array.length; i++) {//从第二的数据开始
            int tem = array[i];
            int j = 0;
            for ( j = i-1; j >=0 ; j--) {
                //从你要排序的数据前一个数据开始，往前遍历，
                if (array[j] > tem){
                    //说明tem的值还比较大，仍要往前遍历，同时将数据往后挪，
                    array[j+1] = array[j];
                }else{
                    //tem已经比前面的数据大了，找到了tem应该插入的位置
                    break;
                }

            }
            array[j+1] = tem;

        }
        long end = System.nanoTime();//纳秒
        System.out.println("插入排序："+(end-start)+"纳秒");
    }

    /*
    2.shell排序
     */
    public static void shellReay(int[] array,int gap){
        for (int i = gap; i < array.length; i++) {//从第二的数据开始
            int tem = array[i];
            int j = 0;
            for ( j = i-gap; j >= 0 ; j = j-gap) {
                //从你要排序的数据前一个数据开始，往前遍历，
                if (array[j] > tem){
                    //说明tem的值还比较大，仍要往前遍历，同时将数据往后挪，
                    array[j+gap] = array[j];
                }else{
                    //tem已经比前面的数据大了，找到了tem应该插入的位置
                    break;
                }

            }
            array[j+gap] = tem;

        }
    }
    public static void shellSort(int[] array){
        long start = System.nanoTime();
        int[] arr = {5,3,1};
        for (int i = 0; i < arr.length; i++) {

            shellReay(array,arr[i]);
        }
        long end = System.nanoTime();//纳秒
        System.out.println("shell排序："+(end-start)+"纳秒");
    }



    /*
    选择排序
     */
    public static void chioseSort(int[] array){
        long start = System.nanoTime();
        int tem =0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[j] < array[i]){
                    //找到最小的数
                    tem = array[i];
                    array[i] = array[j];
                    array[j] = tem;
                }
            }
        }
        long end = System.nanoTime();//纳秒
        System.out.println("选择排序："+(end-start)+"纳秒");
    }
    /*
    堆排序
     */



    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = i;
        }
//        Random random = new Random();
//        for(int i = 0;i < array.length;i++){
//            array[i] = random.nextInt(100000)+1;
//            //array[i] = i;
//        }
        chioseSort(array);
        System.out.println("===================");
        System.out.println(Arrays.toString(array));
    }
}
