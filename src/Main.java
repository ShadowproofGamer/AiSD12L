public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addEdge(0,1,10);
        g.addEdge(0,3,30);
        g.addEdge(0,4,100);
        g.addEdge(1,2,50);
        g.addEdge(2,4,10);
        g.addEdge(3,2,20);
        g.addEdge(3,4,60);
        g.printAdjacencyList();
        g.findShortestDistance(0, 4);
    }
}
