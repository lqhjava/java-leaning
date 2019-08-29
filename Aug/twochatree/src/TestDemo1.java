import java.util.Arrays;

public class TestDemo1 implements IHeap {
    private int[] elem;
    private int size;
    private final int DEAFULT_VALUE=10;

    public TestDemo1() {
        this.size = 0;
        this.elem = new int[DEAFULT_VALUE];
    }

    private void swap(int[] arr,int x,int y){
        int tem = 0;
        tem = arr[x];
        arr[x] = arr[y];
        arr[y] = tem;
    }
    @Override
    public void adjustDown(int root, int len) {
        //向下调整 大根堆
        int parent = root;//根
        int child = 2*root+1;//左孩子
        while(child < len){
            if(child+1 < len){
                //有右子树
                //找最大的
                if(elem[child] < elem[child+1]){
                    child  = child+1;
                }
            }
            //交换
            if(elem[child] > elem[parent]){
                swap(elem,parent,child);
                //接着往下调整
                parent = child;
                child = child*2+1;
            }else {
                break;
            }
            //
        }
    }

    @Override
    public void initHeap(int[] array) {
        //数据入堆
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            this.size++;
        }
        //调整
        for (int i = ((this.elem.length-1-1)/2); i >=0 ; i--) {
            adjustDown(i,this.elem.length);
        }

    }

    @Override
    public void adjustUp(int child) {
            int parent = (child-1)/2;
            while(child >0){
                if(elem[child] > elem[parent]){
                    swap(elem,child,parent);
                    child = parent;
                    parent = (parent-1)/2;

                }else {
                    break;
                }
            }
    }

    @Override
    public void pushHeap(int item) {
        //检查是否满了
        if(this.size == DEAFULT_VALUE){
            //满了 扩容
            this.elem = Arrays.copyOf(this.elem,2*elem.length);
        }
        this.elem[this.size] = item;
        this.size++;
        adjustUp(this.size-1);
    }

    @Override
    public int popHeap() {
        if(this.size== 0){
            return -1;
        }
        //删除
        int tem = elem[0];
        this.elem[0] = this.elem[this.size-1];
        this.size--;
        adjustDown(0,this.size);
        return tem;
    }

    @Override
    public int getHeapTop() {
        return elem[0];
    }

    @Override
    public void heapSort() {
        //排序 升序
        for (int i = 0; i < this.size; i++) {
            swap(elem,0,size-1-i);
            adjustDown(0,this.size-1-i);
        }

    }

    @Override
    public void show() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(elem[i]+"   ");
        }
        System.out.println();
    }
}
