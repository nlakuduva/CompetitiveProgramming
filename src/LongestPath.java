import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class LongestPath 
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int numV = scan.nextInt();
		int numE = scan.nextInt();
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		int[] inDegree = new int[numV];
		Map<Integer, List<Integer>> backptrs = new HashMap<Integer, List<Integer>>();


		for(int i = numV; i > 0; i--)
		{
			List<Integer> nbrs = new ArrayList<Integer>();
			graph.put(i, nbrs);
			backptrs.put(i, new ArrayList<Integer>());
		}
		
		for(int i = numE-1; i >= 0; i--)
		{
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			
			graph.get(v1).add(v2);
			backptrs.get(v2).add(v1);
			
			inDegree[v2-1]++;
		}
		
		List<Integer> answer = getTopologicalOrdering(numV, inDegree, graph);
		if (!answer.isEmpty() && answer.size() == numV)
		{
			DP(answer, graph);
		}
	}
	
    private static ArrayList<Integer> getTopologicalOrdering(int n, int[] inDegree, Map<Integer, List<Integer>> graph) {
        int[] remainingInDegree = new int[n];

        ArrayList<Integer> zeros = new ArrayList<>();
        ArrayList<Integer> sort = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            remainingInDegree[i-1] = inDegree[i-1];
            if (remainingInDegree[i-1] == 0) {
                zeros.add(i);
            }
        }

        while (!zeros.isEmpty()) {
            int u = zeros.get(0);
            zeros.remove(0);
            sort.add(u);
            for (int v : graph.get(u)) {
                if (--remainingInDegree[v-1] == 0) {
                    zeros.add(v);
                }
            }
        }

        return sort;
    }
    
    private static void DP(List<Integer> list, Map<Integer, List<Integer>> graph)
    {
    	int[] estimates = new int[list.size()];
    	//Arrays.fill(estimates, 1);
    	int i = 1;
    	int j = 0;
		while(i < list.size())
		{
			if (dfs(list.get(j), graph, list.get(i)))
				estimates[i] = Math.max(estimates[i], estimates[j] + 1);
			j++;
			if(i == j)
			{
				i++; 
				//j = 0;
			}
		}
		int max = estimates[0];
		System.out.println(Arrays.toString(estimates));

		for (int f = 1; f < estimates.length; f++) 
		{
		    if (estimates[f] > max) 
		    {
		      max = estimates[f];
		    }
		}
		System.out.println(max);
    }
    
    public static boolean dfs(int n, Map<Integer, List<Integer>> neighbors, int goal)
	{
    	boolean[] visited = new boolean[neighbors.size()];
		Stack<Integer> toVisit = new Stack<Integer>();
		toVisit.push(n);
		while (!toVisit.isEmpty()) 
		{
			int node = toVisit.pop();
			if(visited[node-1] == true)
				continue;
			if(node == goal)
				return true;
			visited[node-1] = true;
			for(int neighbor: neighbors.get(node))
				toVisit.push(neighbor);
		}
		
		return false;
	}
}
