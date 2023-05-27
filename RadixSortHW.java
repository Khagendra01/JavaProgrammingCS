import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortHW
{
	public static int width(int[] a)
	{
		Integer max = a[0];
		for( int i = 0 ; i < a.length ; i++) {
			if ( a[i] > max ) {
				max = a[i];
			}
		}		
		int count = 0;
		while( max > 0) {
			count++;
			max/=10;
		}
		return count;
	}

	public static int getDigit(int value, int digit)
	{
		
		return (int) (value / Math.pow(10, digit)) % 10;
	}

	public static void sort(int[] a)
	{
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
				
		for(int i = 0; i < 10; i++ ) {
			buckets.add( new ArrayList<Integer>());
		}
		
		int size = width(a);
		
		for(int pass = 0; pass < size ; pass++) {
			emptyBuckets(a, buckets);
			
			fillBucket(buckets, a, pass);
			
			int pointer = 0;
			for( ArrayList<Integer> mySubSet : buckets) {
				for( Integer eachOne : mySubSet ) {
					a[pointer] = eachOne;
					pointer++;
				}
			}				
		}		
		
		// to do
	}

	public static void emptyBuckets(int[] a, ArrayList<ArrayList<Integer>> buckets)
	{
		for(int i = 0; i < 10; i++) {
			buckets.get(i).clear();
		}
	}

	public static void fillBucket(ArrayList<ArrayList<Integer>> buckets, int[] a, int position)
	{
		for(int i = 0; i < a.length ; i++) {
			int getNum = getDigit(a[i], position);
			buckets.get(getNum).add(a[i]);
		}
	}

	public static void main(String[] args)
	{
		int[] a = new int[] { 333, 22, 0, 1, 666666, 5475, 99, 4444, 2, 77};
		
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}