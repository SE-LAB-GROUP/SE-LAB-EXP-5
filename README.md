# Software Engineering Lab

## Experiment #5

### Check cycle using DFS

At first, we implemented the cycle detection algorithm using DFS in a graph.

After profiling the Main class, which creates a graph with 10,000,000 vertices 
and runs the hasCycle method, we noticed a large memory usage, especially in the `addEdge` method. 
The profiling results indicated that the `edgesMap` was consuming a large amount of heap memory.

![Main Profile](./images/MainProfile.png)

We made the following optimizations:

- Utilizing `pathSet` for Cycle Detection: 
We introduced a pathSet data structure to keep track of vertices in the path from the source vertex to the current vertex. 
This `pathSet` is then used to detect cycles efficiently.

- Switching to `visitedSet`: 
Instead of maintaining a visitedMap, we replaced it with a HashSet named `visitedSet`. 
This change helped in further improving the performance of the cycle detection algorithm.

Here is the resources used by the `Main` and the `OptimizedMain` classes.

![Main Resources](./images/MainResources.png)
![Main Resources](./images/OptimizedMainResources.png)
