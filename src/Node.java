import java.util.LinkedList;

public class Node {
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
}
