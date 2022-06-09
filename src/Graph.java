import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Node> map;

    public Graph() {
        map = new LinkedList<>();
    }


    public LinkedList<Node> getMap() {
        return map;
    }

    public void addNode(int value) {
        addNode(new Node(value));
    }

    public void addNode(Node node) {
        boolean exist = nodeExist(node);
        if (exist) {
            map.remove(getNode(node.getValue()));
        }
        map.add(node);
    }

    public void addEdge(int source, int destination, int weight) {

        getNode(source).addEdge(new Edge(getNode(destination), weight));

    }

    private boolean nodeExist(int value) {
        return nodeExist(new Node(value));
    }

    private boolean nodeExist(Node node) {
        for (Node n : map) {
            if (n.getValue() == node.getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean edgeExist(Node node, Edge edge) {
        if (!nodeExist(node)) return false;
        Node n = getNode(node.getValue());
        for (Edge e : n.list) {
            if (e.destination == edge.destination) return true;
        }
        return false;
    }

    public Node getNode(int value) {
        for (Node n : map) {
            if (n.getValue() == value) return n;
        }
        Node n = new Node(value);
        addNode(n);
        return n;
    }

    public void printAdjacencyList() {
        System.out.println("Adjacency list: ");
        for (Node n : map) {
            StringBuilder resultN = new StringBuilder(n.getValue() + " ");
            if (n.list.size() != 0) {
                resultN.append("- ");
                for (Edge e : n.list) {
                    resultN.append(e.destination.getValue()).append(" ");
                }
            }

            System.out.println(resultN);
        }
    }

    public int dijkstraAlgorithm(int source, int destination){
        return dijkstraAlgorithm(getNode(source), getNode(destination));
    }
    public int dijkstraAlgorithm(Node source, Node destination) {
        //initialization
        int nodesNumber = map.size();
        boolean[] checked = new boolean[nodesNumber];
        int[] distance = new int[nodesNumber];
        int[] predecesor = new int[nodesNumber];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(checked, false);
        distance[source.getValue()] = 0;

        //main loop (finding next node to analize)
        for (int i = 0; i < nodesNumber-1; i++) {

            int u = minDistance(distance, checked);
            checked[u] = true;

            //getting currently analyzed node
            Node src = getMap().get(u);
            //inside loop (analyzing all edges from the node)
            for (int j = 0; j < src.list.size(); j++) {
                Edge temp = src.list.get(j);

                //checking if the node on the list was already processed and if it wasn't than checking if the new distance is smaller than the current
                if (!checked[temp.destination.getValue()]
                        && distance[u] + temp.weight < distance[temp.destination.getValue()]){

                    //changing the distance
                    distance[temp.destination.getValue()] = distance[u] + temp.weight;
                }

            }
        }
        printSolution(distance);
        //temp solution
        return distance[destination.getValue()];
    }

    void printSolution(int[] distance)
    {
        System.out.println("\nDistance from source to each node (0 = source  and  "+Integer.MAX_VALUE+" = unreachable)");
        System.out.println("Node \t Distance");
        for (int i = 0; i < map.size(); i++)
            System.out.println(i + " \t\t " + distance[i]);
    }

    private int minDistance(int[] distance, boolean[] checked){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < map.size(); i++) {
            if (!checked[i]&&distance[i]<=min){
                min = distance[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public void findShortestDistance(int source, int destination){
        System.out.println("\nThe shortest path from "+source+" to "+destination+" is "+dijkstraAlgorithm(source, destination));
    }
}