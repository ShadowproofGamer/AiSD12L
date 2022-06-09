import java.util.LinkedList;

public class Node implements Comparable<Node>{
    private int value;
    LinkedList<Edge> list;
    public Node(int value){
        list = new LinkedList<>();
        this.value = value;
    }
    public void addEdge(Edge edge){
        list.add(edge);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(value, n.value);
    }
}
