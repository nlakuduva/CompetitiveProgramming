import java.util.*;

public class StronglyConnectedComponent 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for(int i = 1; i <= rows*cols; i++)
		{
			List<Integer> nbrs = new ArrayList<Integer>();
			graph.put(i, nbrs);
		}
		
		// add all the horizontal roads
		char[] hArrows = scan.next().toCharArray();
		for(int rowArrows = 0; rowArrows < hArrows.length; rowArrows++)
		{
			char arrow = hArrows[rowArrows];
			if(arrow == '>')
			{
				int endRowVal = (rowArrows+1) * cols;
				int startVal = endRowVal - (cols-1);
				for(int c = 1; c < cols; c++)
				{
					graph.get(startVal).add(startVal+1);
					++startVal;
				}
			}
			else
			{
				int endRowVal = (rowArrows+1) * cols;	
				for(int c = cols; c > 1; c--)
				{
					graph.get(endRowVal).add(endRowVal-1);
					--endRowVal;
				}
			}
		}
		
		// add all the vertical roads
		char[] vArrows = scan.next().toCharArray();
		for(int colArrows = 1; colArrows <= cols; colArrows++)
		{
			char arrow = vArrows[colArrows-1];
			if(arrow == 'v')
			{
				int startVal = colArrows;	
				for(int r = 1; r < rows; r++)
				{
					graph.get(startVal).add(startVal+cols);
					startVal += cols;
				}
			}
			else
			{
				int endVal = colArrows + cols*(rows-1);
				for(int r = rows; r > 1; r--)
				{
					graph.get(endVal).add(endVal-cols);
					endVal -= cols;
					
				}
			}
		}

		//printGraph(graph);
		boolean valid = true;
		for(int node: graph.keySet())
		{
			boolean[] visited = new boolean[graph.keySet().size()];
			dfs(node, visited, graph);
			for(int i = 0; i < visited.length; i++)
			{
				if(visited[i] == false)
				{
					valid = false;
					break;
				}
			}
			
			
		}
		if(valid)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	
	
	private static void printGraph(Map<Integer, List<Integer>> graph)
	{
		for(int i : graph.keySet())
		{
			System.out.print(i + ": ");
			List<Integer> list = graph.get(i);
			for(int c = 0; c < list.size(); c++)
			{
				System.out.print(list.get(c) + " ");
			}
			System.out.println();
		}
	}
	public static void dfs(int n, boolean []visited, Map<Integer, List<Integer>> neighbors)
	{
		
		Stack<Integer> toVisit = new Stack<Integer>();
		toVisit.push(n);
		while (!toVisit.isEmpty()) 
		{
			int node = toVisit.pop();
			if(visited[node-1] == true)
				continue;
			visited[node-1] = true;
			for(int neighbor: neighbors.get(node))
				toVisit.push(neighbor);
		}		
	}
}
