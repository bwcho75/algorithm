
public class QuickSortTest {

	public static void main(String args[]){
		int[] a = {1,6,2,0,3,2,1};
		
		QuickSort q = new QuickSort();
		
		q.sort(a, 0, a.length-1);
		
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
