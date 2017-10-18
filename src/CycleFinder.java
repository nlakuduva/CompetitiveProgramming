import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class CycleFinder
{
	private int number;
//	private int cost;
	private CycleFinder prev;
	public List<CycleFinder> neighbors;
	// 10^6 * 10^5 = 10^11 = not fit in an integer
	
	public CycleFinder(int num, CycleFinder previous)
	{
		number = num;
		//cost = c;
		prev = previous;
	}
	
	public int getNodeNumber()
	{
		return number;
	}
	
//	public int getCost()
////	{
////		return cost;
////	}
////	
////	public void setCost(int num)
////	{
////		cost += num;
////	}
////	
	public CycleFinder getPrev()
	{
		return prev;
	}
	
//	@Override
//	public int compareTo(CycleFinder o) {
//		return this.cost - o.getCost();
//	}
	
	public String toString()
	{
		return "" + number;
	}
	
	public static void main (String[] args)
	{
		String s = "10 10 1 4 201 2 3 238 3 4 40 3 6 231 3 8 45 4 5 227 4 6 58 4 9 55 5 7 14 6 10 242";
		Scanner scan = new Scanner(System.in);
		int numV = scan.nextInt();
		int numE = scan.nextInt();
		//int goal = scan.nextInt();
		Map<Integer, List<CycleFinder>> graph = new HashMap<Integer, List<CycleFinder>>();
		for(int i = numV; i > 0; i--)
		{
			List<CycleFinder> nbrs = new ArrayList<CycleFinder>();
			graph.put(i, nbrs);
		}
		
		for(int i = numE-1; i >= 0; i--)
		{
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			
			graph.get(v1).add(new CycleFinder(v2, null));
			//graph.get(v2).add(new CycleFinder(v1, 1, null));

		}
		
//		for(int i : graph.keySet())
//		{
//			System.out.print(i + ": ");
//			List<CycleFinder> list = graph.get(i);
//			for(int c = 0; c < list.size(); c++)
//			{
//				System.out.print(list.get(c).getNodeNumber + " ");
//			}
//			System.out.println();
//		}
		boolean res = false;
		for(int v = 1; v <= numV; v++)
		{
			if(res = dfs(graph, v))
			{
				System.out.println("YES");
				break;
			}
		}
		
		if (!res)
			System.out.println("NO");
	}

	private static boolean dfs(Map<Integer, List<CycleFinder>> graph, int goal)
	{
		Stack<CycleFinder> toVisit = new Stack<CycleFinder>();
		boolean[] visited = new boolean[graph.size()];
		
		CycleFinder start = new CycleFinder(goal, null);
		toVisit.push(start);
		
		while (!toVisit.isEmpty())
		{
			CycleFinder node = toVisit.pop();
			int nodeNum = node.getNodeNumber();
			if(nodeNum == goal && node.getPrev() != null)
			{
				//System.out.println("YES");
				return true;
			}
				
			visited[nodeNum-1] = true;
			List<CycleFinder> neighbors = graph.get(nodeNum);
			int size = neighbors.size();
			for(int i = size-1; i >= 0; i--)
			{
				CycleFinder nbr = neighbors.get(i);
				if(visited[nbr.getNodeNumber()-1] == false)
				{
					CycleFinder nextNode = new CycleFinder(nbr.getNodeNumber(), node);
					//System.out.println(nbr.getNodeNumber());
					toVisit.push(nextNode);
				}
			}
			//System.out.println();
			
			if(nodeNum != start.getNodeNumber())
				visited[start.getNodeNumber()-1] = false;
				
		}
		
		
		return false;
	}
	
}

