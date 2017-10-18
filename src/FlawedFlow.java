import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class FlawedFlow 
{
	private static class FastIO 
	{
        private BufferedReader reader;
        private PrintWriter writer;

        private StringTokenizer tokenizer;

        private FastIO(InputStream in, PrintStream out) {
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.writer = new PrintWriter(new BufferedOutputStream(out));
        }

        private String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }

            return tokenizer.nextToken();
        }

        private int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        private void println(String line) {
            writer.println(line);
        }

        private void close() throws IOException {
            reader.close();
            writer.close();
        }

    }

	public static class Edge 
    {
        int dest;
        int cost;
        int dir ;
        int i;
 
        public Edge(int dest, int c, int d, int i) 
        {
            this.dest = dest;
            cost = c;
            dir = d;
            this.i = i;
        }
    }
 
    public static void main(String[] args) throws IOException
    {
        FastIO scan = new FastIO(System.in, System.out);
        int numV = scan.nextInt();
        int numE = scan.nextInt();
        Map<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
        int[] half = new int[numV+1];
        int[] current = new int[numV+1];
        boolean[] visited = new boolean[numV+1];
        int[] direction = new int[numE+1];
        
		for(int i = 0; i <= numV; i++)
		{
			List<Edge> nbrs = new ArrayList<Edge>();
			graph.put(i, nbrs);
		}
		
		for(int i = 0; i < numE; i++)
		{
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			int weight = scan.nextInt();
			
			graph.get(v1).add(new Edge(v2, weight, 0, i));
			graph.get(v2).add(new Edge(v1, weight, 1, i));
	        current[v1] += weight;
	        current[v2] += weight;
			

		}
        for (int i = 0; i < numV; i++) 
            half[i] = current[i] / 2;
        
        dfs(1, graph, half, current, visited, direction);
        
        for (int i = 0; i < numE; i++) 
            System.out.println(direction[i]);
    }
    
	/* Depth-first search */
	public static void dfs(int n, Map<Integer, List<Edge>> graph, int[] half, int[] current, boolean[] visited, int[] direction)
	{   
		Stack<Integer> toVisit = new Stack<Integer>();
		toVisit.push(n);
		visited[n] = true;
		while (!toVisit.isEmpty()) 
		{
			int node = toVisit.pop();
			for(Edge e: graph.get(node))
			{
				if(visited[e.dest] == true)
					continue;
				
                direction[e.i] = e.dir;
                current[e.dest] -= e.cost;
                if (current[e.dest] == half[e.dest] && e.dest != graph.size()-1) 
                {
                    visited[e.dest] = true;
                    toVisit.push(e.dest);
                }
			}
				
		}		
	}
}