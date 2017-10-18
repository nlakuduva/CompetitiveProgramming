import java.util.Scanner;

public class AirplaneSpeed 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++)
		{
			int num = scan.nextInt();
			double total = 0;
			double totalHours = 0;
			for (int s = 0; s < num; s++)
			{
				long speed = scan.nextLong();
				long hours = scan.nextLong();
				totalHours += hours;
				total += (hours*speed);	
			}
			
			System.out.println((long)(Math.round(total/totalHours)));
		}
	}
}
