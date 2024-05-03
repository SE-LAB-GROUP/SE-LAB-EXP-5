package code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class OptimizedGraph {

    private final ArrayList<ArrayList<Integer>> adjacencyList;
    private final HashSet<Integer> visitedSet;


    public OptimizedGraph(int verticesCount) {
        adjacencyList = new ArrayList<>();
        visitedSet = new HashSet<>();
        for (int i = 0; i < verticesCount; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
    }


    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
    }

    public boolean hasCycle(int source) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(source);

        HashSet<Integer> pathSet = new HashSet<>();
        while (!deque.isEmpty()) {
            int v = deque.pop();
            if (!visitedSet.contains(v)) {
                visitedSet.add(v);
                pathSet.add(v);

                for (int n : adjacencyList.get(v)) {
                    if (!visitedSet.contains(n)) {
                        deque.push(n);
                    } else if (pathSet.contains(n)) {
                        return true;
                    }
                }
            }
            pathSet.remove(v);
        }
        return false;
    }
}
