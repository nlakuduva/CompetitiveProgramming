import java.util.*;

public class Djikstra implements Comparable<Djikstra>
{
	private int number;
	private int cost;
	private Djikstra prev;
	public List<Djikstra> neighbors;
	// 10^6 * 10^5 = 10^11 = not fit in an integer
	
	public Djikstra(int num, int c, Djikstra previous)
	{
		number = num;
		cost = c;
		prev = previous;
		//neighbors = new ArrayList<Djikstra>();
	}
	
	public int getNodeNumber()
	{
		return number;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public void setCost(int num)
	{
		cost += num;
	}
	
	public Djikstra getPrev()
	{
		return prev;
	}
	
	@Override
	public int compareTo(Djikstra o) {
		return this.cost - o.getCost();
	}
	
	public String toString()
	{
		return "" + number;
	}
	
	public static void main (String[] args)
	{
//    	Stopwatch watch = new Stopwatch();
//    	watch.start();
		//String s = "10 10 1 4 201 2 3 238 3 4 40 3 6 231 3 8 45 4 5 227 4 6 58 4 9 55 5 7 14 6 10 242";
		String s = "10 10 1 4 1 2 3 1 3 4 1 3 6 1 3 8 1 4 5 1 4 6 1 4 9 1 5 7 1 6 10 1";
		Scanner scan = new Scanner(System.in);
		int numV = scan.nextInt();
		int numE = scan.nextInt();
		Map<Integer, List<Djikstra>> graph = new HashMap<Integer, List<Djikstra>>();
		//List<Djikstra> graph = new ArrayList<Integer>()
		for(int i = numV; i > 0; i--)
		{
			List<Djikstra> nbrs = new ArrayList<Djikstra>();
			graph.put(i, nbrs);
		}
		
		for(int i = numE-1; i >= 0; i--)
		{
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			int weight = scan.nextInt();
			
			graph.get(v1).add(new Djikstra(v2, weight, null));
			graph.get(v2).add(new Djikstra(v1, weight, null));

		}
		
//		for(int i : graph.keySet())
//		{
//			System.out.print(i + ": ");
//			List<Djikstra> list = graph.get(i);
//			for(int c = 0; c < list.size(); c++)
//			{
//				System.out.print(list.get(c).getNodeNumber + " ");
//			}
//			System.out.println();
//		}
		djikstra(graph, numV);
		
//		watch.stop();
//		System.out.println(watch);
	}

	private static void djikstra(Map<Integer, List<Djikstra>> graph, int goal)
	{
		PriorityQueue<Djikstra> queue = new PriorityQueue<Djikstra>();
		boolean[] visited = new boolean[graph.size()];
		
		Djikstra start = new Djikstra(1, 0, null);
		queue.add(start);
		
		while (!queue.isEmpty())
		{
			Djikstra node = queue.poll();
			int nodeNum = node.getNodeNumber();
			if(nodeNum == goal)
			{
				List<Djikstra> prevs = new ArrayList<Djikstra>();
				prevs.add(node);
				Djikstra prev = node.getPrev();
				//StringBuilder output = new StringBuilder("" + nodeNum);
				while(prev != null)
				{
					//output.insert(0, prev.getNodeNumber() + " ");
					prevs.add(prev);
					prev = prev.getPrev();
				}
				for(int i = prevs.size()-1; i > 0; i--)
					System.out.print(prevs.get(i) + " ");
				System.out.println(prevs.get(0));
				return;
			}
				
			visited[nodeNum-1] = true;
			List<Djikstra> neighbors = graph.get(nodeNum);
			int size = neighbors.size();
			for(int i = size-1; i >= 0; i--)
			{
				Djikstra nbr = neighbors.get(i);
				if(visited[nbr.getNodeNumber()-1] == false)
				{
					int cost = node.getCost() + nbr.getCost();
					Djikstra nextNode = new Djikstra(nbr.getNodeNumber(), cost, node);
					queue.add(nextNode);
				}
			}
		}
		
		System.out.println(-1);
		
	}
	
	private static boolean isVertexANeighbor(Map<Integer, List<Integer[]>> graph, int v1, int v2, int weight)
	{
		//System.out.println(v1);
		List<Integer[]> neighbors = graph.get(v1);
		if(neighbors == null)
			return false;
		for(int n = 0; n < neighbors.size(); n++)
		{
			Integer[] neighbor = neighbors.get(n);
			if(neighbor[0] == v2)
			{
				if(weight < neighbor[1])
				{
					neighbor[1] = weight;
					neighbors.set(n, neighbor);
					graph.put(v1, neighbors);
					return true;
				}
					
			}
				
		}
		
		return false;
	}
	
}

