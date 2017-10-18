import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Testing 
{
    public static class Tuple 
    {
        int source;
        int dest;

        public Tuple(int s, int d) 
        {
            source = s;
            dest = d;
        }
        
        @Override
        public boolean equals(Object t)
        {
        	Tuple t2 = (Tuple) t;
        	return (source == t2.source && t2.dest == dest);
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
    	Map<Tuple, Boolean>  eVisited = new HashMap<Tuple, Boolean>();
    	System.out.println(eVisited);
    	Tuple t1 = new Tuple(1,2);
    	
    	eVisited.put(t1, true);
//    	eVisited.put(t2, false);
    	Tuple t2 = findTuple(eVisited, 1, 2);
    	System.out.println(eVisited.get(t2));
    }
    
	public static Tuple findTuple(Map<Tuple, Boolean>  eVisited, int s, int d)
	{
		for (Tuple t : eVisited.keySet())
		{
			if(t.source == s && t.dest == d)
				return t;
		}
		
		return null;
	}

}
