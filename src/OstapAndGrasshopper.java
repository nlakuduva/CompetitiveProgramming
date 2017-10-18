import java.util.Scanner;

public class OstapAndGrasshopper 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		scan.nextInt();
		int jump = scan.nextInt();
		
		String line = scan.next();
		char[] cells = line.toCharArray();
		boolean insectFound = false;
		
		int gIndex = -1;
		int i = 0;
		while(gIndex < 0)
		{
			if(cells[i] == 'G')
				gIndex = i;
			i++;
		}
		
		//traverse backwards
		int c;
		for(c = gIndex; c >= 0; c-=jump)
		{
			if(cells[c] == '#')
				break;
			
			if(cells[c] == 'T')
			{
				insectFound = true;
				break;
			}
		}
		c += jump;
		
		//traverse forwards
		for(;c < cells.length; c+=jump)
		{
			if(cells[c] == '#')
				break;
			
			if(cells[c] == 'T')
			{
				insectFound = true;
				break;
			}
		}
		
		if(insectFound == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
}
