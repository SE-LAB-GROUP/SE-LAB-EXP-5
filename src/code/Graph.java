package code;

import java.util.*;

public class Graph {

    private final ArrayList<ArrayList<Integer>> adjacencyList;
    private final HashMap<Integer, Boolean> visitedMap;
    private final HashMap<Integer, HashSet<Integer>> edgesMap;

    public Graph(int verticesCount) {
        adjacencyList = new ArrayList<>();
        visitedMap = new HashMap<>();
        edgesMap = new HashMap<>();
        for (int i = 0; i < verticesCount; ++i) {
            adjacencyList.add(new ArrayList<>());
            visitedMap.put(i, false);
            edgesMap.put(i, new HashSet<>());
        }
    }


    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        edgesMap.get(v).add(w);
    }

    public boolean hasCycle(int source) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(source);

        while (!deque.isEmpty()) {
            int v = deque.pop();
            if (Boolean.FALSE.equals(visitedMap.get(v))) {
                visitedMap.put(v, true);
                for (int i = 0; i < adjacencyList.get(v).size(); i++) {
                    int n = adjacencyList.get(v).get(i);
                    if (Boolean.FALSE.equals(visitedMap.get(n))) {
                        deque.push(n);
                    } else if (Boolean.TRUE.equals(visitedMap.get(n)) && !edgesMap.get(v).contains(n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
