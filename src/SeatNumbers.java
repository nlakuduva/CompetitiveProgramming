import java.util.Scanner;

public class SeatNumbers 
{
	public static void main(String[] args)
	{
		// A B C D E F = 6 Letters
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++)
		{
			String num = scan.next();
			long n = Integer.parseInt(num.substring(0, num.length()-1));
			System.out.println(n * 6);
		}
	}
}
