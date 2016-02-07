public class QuickSort {
	
	int partition(int[] d,int l,int r) {
		int i = l,j = r;
		int p = d[(l+r)/2];
		int tmp ;
		while(i<=j) {
			while(d[i]<p) i++;
			while(d[j]>p) j--;
			
			if(i<=j) {
				tmp = d[i];
				d[i] = d[j];
				d[j] = tmp;
				i++;
				j--;
			}
		}
		
		return i;
	}
	public void sort(int[] d,int l,int r) {
		int i = partition(d,l,r);
		
		if(i-1>l) sort(d,l,i-1);
		if(i<r) sort(d,i,r);
	}

}
