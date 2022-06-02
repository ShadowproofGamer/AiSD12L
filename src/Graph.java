// Java program to implement Graph
// with the help of Generics

import java.util.*;

class Graph {

    // We use Hashmap to store the edges in the graph
    private Map<Integer, HashMap<Integer, Integer> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(Integer s)
    {
        map.put(s, new HashMap<>());
    }


    public void addEdge(Integer source, Integer destination, Integer length)
    {
        // adds source if not yet existing
        if (!map.containsKey(source))
            addVertex(source);

        // adds destination if not yet existing
        if (!map.containsKey(destination))
            addVertex(destination);

        // links source to destination with weight
        map.get(source).put(destination, length);
    }

    public void dijkstraAlgorithm(Integer start){
        ArrayList<Integer> endArray = new ArrayList<>();
        ArrayList<Integer> startArray = new ArrayList<>(map.keySet());
        Integer[] vertexArray = new Integer[map.keySet().size()];
        Integer[] previousArray = new Integer[map.keySet().size()];
        //filling arrays
        Arrays.fill(vertexArray, 999999999);
        Arrays.fill(previousArray, -1);
        //making first array cost
        vertexArray[start] = 0;
        



    }






    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount()
    {
        int count = 0;
        for (Integer v : map.keySet()) {
            count += map.get(v).size();
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(Integer s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(Integer s, Integer d)
    {
        if (map.get(s).containsKey(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }





    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Integer v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (Map.Entry<Integer, Integer> entry: map.get(v).entrySet()) {
                builder.append(entry.getKey().toString()).append(" ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}
