package code;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int verticesCount = 10_000_000;
        Graph graph = new Graph(verticesCount);

        Random random = new Random();
        for (int i = 0; i < verticesCount; i++) {
            int edgesCount = random.nextInt(10);
            for (int j = 0; j < edgesCount; j++) {
                int destVertex = random.nextInt(verticesCount);
                graph.addEdge(i, destVertex);
            }
        }

        System.out.println(graph.hasCycle(0));
    }
}
