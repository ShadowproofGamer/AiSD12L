import java.io.*;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Graph graph = load();

        System.out.println("write source node number: ");
        int source = scan.nextInt();

        System.out.println("write destination node number: ");
        int destination = scan.nextInt();

        graph.findShortestDistance(source, destination);
        graph.printAdjacencyList();

        /*
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
         */
    }




    public static Graph load(){
        Graph result = new Graph();
        try(
                BufferedReader br = new BufferedReader(new FileReader("src/txt.txt"));
        ){
            String t=".";
            while ((t = br.readLine()) != null && t.length()>0){
                String[] s = (t.split("\\.|,| - | – |;| ; |\\s+"));
                int source = Integer.parseInt(s[0]);
                int destination = Integer.parseInt(s[1]);
                int weight = Integer.parseInt(s[2]);
                //System.out.println(Arrays.toString(s));
                result.addEdge(source, destination, weight);

            }


        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("brak pliku");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
        return result;
    }
}
