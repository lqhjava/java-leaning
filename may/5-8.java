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
    public static void adjust(int[] array,int start,int end){
        //把树变为大根堆

        //丛树的左孩子开始 找到这棵树的最大值
        int tem = array[start];//需要引入额外变量
        //start 左孩子坐标 2*start+1
        for (int i = 2*start+1; i < end; i= 2*i +1) {
            //i = 2*i+1 i每次都找他的左孩子

            if((i < end) && array[i] < array[i+1]){
                //如果i 在树内 并且左孩子小于右孩子
                i++;//i往后走 找到最大自
            }
            if(array[i] > tem){
                //找到比根节点大的数据
                array[start] = array[i];
                //再找这个子树还有没有字数
                start = i;
            }else if(array[i] < tem){

                break;
            }
        }
        array[start] = tem;

    }

    public static void heapSort(int[] array){
        long start = System.nanoTime();//纳秒

        //从最后一棵树开始 把每个树都能变成大根堆
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            //把每棵树都变成大根堆
            adjust(array,i,array.length-1);
        }
        //此时 树以便为大根堆  把根节点和最后一个值进行交换
        for (int j = 0; j <= array.length-1; j++) {
            //根节点
            int tmp = array[0];
            //交换
            array[0] = array[array.length-1-j];
            array[array.length-1-j] = tmp;
            //此时 最后一个数据已经有序 下一次不用排序
            //再把剩下的数据在拍成大根堆 重复交换 直到最后一次 所有数据有序
            adjust(array,0,array.length-1-j-1);
        }
        long end = System.nanoTime();//纳秒
        System.out.println("堆排序："+(end-start)+"纳秒");
    }

    /*
    交换排序（冒泡排序）
     */
    public static void boubSort(int[] array){
        long start = System.nanoTime();//纳秒

        int tem = 0;
        for(int i = array.length; i > 0;i--){
            for(int j = 1; j < i; j++){
                if(array[j-1] >array[j]){
                    tem = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tem;
                }
            }
        }
        long end = System.nanoTime();//纳秒
        System.out.println("冒泡排序："+(end-start)+"纳秒");
    }

    /*
    快速排序
     */
    public static int partion(int[] array,int low,int high){
        //基准
        int tmp = array[low];
        //
        while (low < high){
            //先从右边找比基准小的数据
            while((low < high) && array[high] >= tmp){
                //一个一个找 没找到
                high--;
            }
            //如果一直没找导
            if(low == high){
                break;
            }else {
                //找到了  在low的位置放入high的数据
                array[low] = array[high];
            }
            //找到了 或者没找到是low==high了 从左往右找比基准打的数据
            while((low < high) && array[low] <= tmp){
                //一个一个遍历
                low++;
            }
            //如果一直没找到
            if(low == high){
                break;
            }else {
                //找到了  在high的位置放入low的数据
                array[high] = array[low];
            }
        }
        //最后的位置放入基准
        array[low] = tmp;
        //把基准返回
        return low;
    }
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static void takeThreeNumber(int[] array,
                                       int low,int high){
        int mid = (low+high)>>>1;
        if(array[mid] > array[low]){
            swap(array,low,mid);
        }
        if(array[mid] > array[high]){
            swap(array,mid,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }

    public static void quick(int[] array,int low,int high){
        //low是从做找 high是从有找
        //如果low和high相遇，代表这组数据已经遍历完
        if(low == high){
            return;
        }
        //对基准进行优化
        takeThreeNumber(array,low,high);

        //第一次快排 以数据的第一个数为基准
        int par = partion(array,low,high);
        //par 是第一次快排的基准
        //递归左边并且保证左边有两个数据以上
        if(par > low+1){
            quick(array,low,par-1);
        }
        //递归右边
        if(par < high-1){
            quick(array,par+1,high);
        }

    }

    //递归实现
    public static void quickSort(int[] array){
        long start = System.nanoTime();//纳秒

        //快速排序的方法
        quick(array,0,array.length-1);

        long end = System.nanoTime();//纳秒
        System.out.println("快速排序："+(end-start)+"纳秒");
    }

    //非递归实现
    public static void quickSort1(int[] array){
        long start = System.nanoTime();//纳秒

        //建立一个栈
        int[] stack = new int[array.length*2];
        int top = 0;

        int low = 0;
        int high = array.length-1;

        //第一次快速排序
        int par = partion(array,low,high);
        //左边有两个数据元素以上
        if(par > low+1){
            //low入栈 par-1作未high入栈
            stack[top++] = low;
            stack[top++] = par-1;
        }
        if(par < high-1){
            //par-作为low入栈
            stack[top++] = par+1;
            stack[top++] = high;
        }
        while (top > 0) {//循环直到站内为空
            //开始出栈  两个一出
            high = stack[--top];
            low = stack[--top];
            //出栈后 进行快排
            par = partion(array,low,high);
            if(par > low+1){
                //区间内还有两个元素以上
                stack[top++] = low;
                stack[top++] = par-1;
            }
            if(par < high-1){
                //区间内还有两个元素以上
                stack[top++] = par+1;
                stack[top++] = high;
            }
        }
        long end = System.nanoTime();//纳秒
        System.out.println("快速排序："+(end-start)+"纳秒");
    }


    /*
    归并排序
     */
    public static void merge(int[] array,int start,int mid,int end){
        //开始和并,在新数组中完成合并
        int[] tem = new int[array.length*2];
        int temp = start;//tem开始的位置
        int start2 = mid+1;//第二部分的开始下标

        int i = start;//开是数组copy的标

        //开始合并
        while(start < mid && start2 < end){
            if(array[start] < array[start2]){
                tem[temp] = array[start];
                temp++;
                start++;
            }else{
                tem[temp] = array[start2];
                temp++;
                start2++;
            }
        }
        //有两种情况跳出
        while(start <= mid){
            tem[temp] = array[start];
            temp++;
            start++;
        }
        while(start2 <= end){
            tem[temp] = array[start2];
            temp++;
            start2++;
        }

        // 两部分已经合并完
        //将合并好的数据copy到原数组中去
        while (i <= end) {
            array[i] = tem[i];
            i++;
        }

    }
    public static void mergeSort(int[] array,int start,int end){
        long start1 = System.nanoTime();//纳秒

        if(start >=end){
            //已经把所有数据分完了
            return;
        }
        int mid = (start + end)/2;
        //左边部分
        mergeSort(array,start,mid);
        //右边部分
        mergeSort(array,mid+1,end);

        //所有数据已经分完， 每部分数据只有一个
        //开始合并
        merge(array,start,mid,end);
        long end1 = System.nanoTime();//纳秒
        System.out.println("快速排序："+(end1-start1)+"纳秒");
    }
    
    //非递归实现
    


    public static void main(String[] args) {
        int[] array = new int[100000];

        Random random = new Random();
        for(int i = 0;i < array.length;i++){
            //array[i] = random.nextInt(100000)+1;
            array[i] = i;
        }
        mergeSort(array,0,array.length-1);
        System.out.println("===================");
        System.out.println(Arrays.toString(array));
    }
}
