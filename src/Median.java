
public class Median 
{
    public static void main(String[] args) 
    {
    	int[] arr1 = {1, 12, 15, 26, 38};
    	int[] arr2 = {45, 46, 47, 48, 50};
    	System.out.println(median(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1));
    }
    
    private static double median(int[] arr1, int lo1, int hi1, int[] arr2, int lo2, int hi2)
    {
		if ((hi1-lo1) == 1 && (hi2-lo2) == 1)
			return (Math.max(arr1[lo1], arr2[lo2]) + Math.min(arr1[hi1], arr2[hi2]))/2.0;
		
		int mid1 = (lo1 + hi1)/2;
		int mid2 = (lo2 + hi2)/2;
		
		if(arr1[mid1] == arr2[mid2])
			return mid1;
		else if(arr1[mid1] > arr2[mid2])
		{
			hi1 = mid1;
			if(((hi2+1) - lo2) % 2 == 0)
				lo2 = mid2-1;
			else
				lo2 = mid2;
		}
		else
		{
			if(((hi1+1) - lo1) % 2 == 0)
				lo1 = mid1+1;
			else
				lo1 = mid1;
			hi2 = mid2;
		}
		
		return median (arr1, lo1, hi1, arr2, lo2, hi2);


    }
}

/*
 * 1 12 15 26 38 --> 15 26 38 --> 15 26  
 * 2 13 17 30 45 --> 2 13 17 --> 13 17
 * 
 * 1 2 3 6 -->  3 6 --> 3 6 
 * 4 6 8 10 --> 4 6 --> 4
 * 
 * */