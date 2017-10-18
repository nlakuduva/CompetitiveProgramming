import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class PingPong 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		int[] starts = new int[testCases];
		int[] ends = new int[testCases];
		boolean[] visited = new boolean[testCases];
		int count = 0;
		for (int i = 0; i < testCases; i++)
		{
			int n = scan.nextInt();
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			
			if(n == 2)
			{
				visited = new boolean[testCases];
				if(dfs(v1, v2, starts, ends, visited, count) == true)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else
			{
				starts[count] = v1;
				ends[count] = v2;
				visited[count] = false;
				++count;
			}

		}

	}

	public static boolean dfs(int v1, int v2, int[] starts, int[] ends, boolean[] visited, int count)
	{	
		Stack<Integer> toVisit = new Stack<Integer>();
		toVisit.push(v1-1);
		while (!toVisit.isEmpty()) 
		{
			int node = toVisit.pop();
			if(visited[node])
				continue;
			if(node == (v2-1))
				return true;
			visited[node] = true;
			for(int i = 0; i < count; i++)
			{
				if((starts[node] > starts[i] && starts[node] < ends[i]))
				{
					toVisit.push(i);
				}
				if((ends[node] > starts[i] && ends[node] < ends[i]))
				{
					toVisit.push(i);
				}
			}
		}
		
		return false;
	}
		

}
