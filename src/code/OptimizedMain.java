package code;

import java.util.*;

public class OptimizedMain {

    public static void main(String[] args) {
        int verticesCount = 10_000_000;
        OptimizedGraph optimizedGraph = new OptimizedGraph(verticesCount);

        Random random = new Random();
        for (int i = 0; i < verticesCount; i++) {
            int edgesCount = random.nextInt(10);
            for (int j = 0; j < edgesCount; j++) {
                int destVertex = random.nextInt(verticesCount);
                optimizedGraph.addEdge(i, destVertex);
            }
        }

        System.out.println(optimizedGraph.hasCycle(0));
    }
}
