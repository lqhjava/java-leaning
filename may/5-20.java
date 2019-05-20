public int findKth(int[] a, int n, int K) {
        // write code here
        int tem = 0;
        for(int i =0;i<a.length;i++){
            for(int j = 1;j<a.length;j++){
                if(a[i]< a[j]){
                    tem = a[i];
                    a[i] = a[j];
                    a[j] = tem;
                }
            }
        }
        return a[k];
