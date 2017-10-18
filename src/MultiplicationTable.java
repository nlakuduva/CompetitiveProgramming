//import java.util.Arrays;
//import java.util.Scanner;
//
//public class MultiplicationTable 
//{
//	public static void main (String[] args)
//	{
//		Scanner scan = new Scanner(System.in);
//		long d1 = scan.nextInt();
//		long d2 = scan.nextInt();
//		long k = scan.nextLong();
//		
//		if(k == 1)
//		{
//			System.out.println(1);
//			return;
//		}
//		else if(k == d1*d2)
//		{
//			System.out.println(d1*d2);
//			return;
//		}
//			
//		//System.out.println(k + " " + d1*d2);
//		//long arr[] = new long[(int)d1*(int)d2];
//		
//		
//		long count = 0;
//		int highest = 0;
//		int reachK = 0;
//		for(int i = 1; i <= d1; i++)
//		{
//			for(int j = 1; j <= d2; j++)
//			{
//				if(count >= arr.length)
//					break;
//				arr[(int)count] = i*j;
//				count++;
//			}
//		}
//		
//		/*  1 2 3 
//		 * 1
//		 * 2
//		 * */
//		
//		Arrays.sort(arr);
//		System.out.println(arr[(int) (k-1)]);
//	}
//}
