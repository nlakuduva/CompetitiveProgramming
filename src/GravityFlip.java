import java.util.Scanner;
import java.util.*;

public class GravityFlip 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int columns = scan.nextInt();
		int[] cubes = new int[columns];
		int max = 0;
		for(int i = 0; i < columns; i++)
		{
			cubes[i] = scan.nextInt();
			if(cubes[i] > max)
				max = cubes[i];
		}
		
		int[][] box = new int[max][columns];
		for(int i = 0; i < columns; i++)
		{
			int row = 0;
			while(row < cubes[i])
			{
				box[row][i] = 1;
				++row;
			}
		}
	
		for(int i = (columns-2); i >=0 ; i--)
		{
			for(int row = 0; row < max; row++)
			{
				int check = box[row][i];
				if(check == 1)
				{
					int nextCol = columns-1;
					while(nextCol > i && box[row][nextCol] >= check)
						nextCol--;
					
					if(i != nextCol)
					{
						box[row][i] = 0;
						cubes[i] = cubes[i] - 1;
						box[row][nextCol] = 1;
						cubes[nextCol] = cubes[nextCol] + 1;
					}
				}
			}
		}
		
		String output = new String();
		for(int n: cubes)
			output += n + " ";
		output.trim();
		System.out.println(output);
		
		scan.close();
	}
	

}
