/******************************************************************************

Juan Esquivel
DS A

*******************************************************************************/
import java.util.*;

public class TopologicalSort
{
    //num of verticies
    private int vertices;          
    
    // list of list that represents graph of adjacency
    private List<List<Integer>> adj;          

    // initializes graph 
    public TopologicalSort(int vertices)
    {
        
        this.vertices = vertices;
        
        // creates the adjacency
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
        {
            adj.add(new ArrayList<>());
        }
        
    }
    // generates the edges
    public void genEdge(int u, int v)
    {
        adj.get(u).add(v);
    }
    
    // goes vertex to vertex checking adjacency
    private void topoSort(int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;
        for (int next : adj.get(v))
        {
            if (!visited[next])
            {
                topoSort(next, visited, stack);
            }
        }
        stack.push(v);
    }

    // process vertexes and checks adjacency using previous code.
    // ensures that all vertices are processed and pushed into stack
    // prints at the end
    public void topologicalSort()
    {
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++)
        {
            
            if (!visited[i])
            {
                topoSort(i, visited, stack);
            }
            
        }
        
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
        
    }

    public static void main(String[] args)
    {
        //builds graph
        TopologicalSort graph = new TopologicalSort(6);
        graph.genEdge(5, 2);
        graph.genEdge(5, 0);
        graph.genEdge(4, 0);
        graph.genEdge(4, 1);
        graph.genEdge(2, 3);
        graph.genEdge(3, 1);

        System.out.println("Topological sort of the given graph:");
        
        graph.topologicalSort();
    }
}
