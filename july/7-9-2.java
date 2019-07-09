import java.util.*;

public class Count2 {
    public int countNumberOf2s(int n) {
        // write code here
        if(n<10)
        {return n>=2?1:0;}
		int base =  (int)Math.pow(10, Math.floor(Math.log10(n)));
		if(n/base == 2){
			return 2*countNumberOf2s(base-1)+countNumberOf2s(n%base)+n%base+1;
        }
		if(n/base < 2){
			return countNumberOf2s(base-1)+countNumberOf2s(n%base);
        }
		return base+(n/base)*countNumberOf2s(base-1)+countNumberOf2s(n%base);

    }
}
