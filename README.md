# Minimum Spanning Tree Algorithms Analysis Report
## Prim's vs Kruskal's Algorithm Performance Comparison

### 1. Summary of Input Data and Algorithm Results

#### Test Cases Overview:
- **Graph 1**: Small input (n=100 vertices, 2466 edges)
- **Graph 2**: Medium input (n=500 vertices, 62431 edges)  
- **Graph 3**: Large input (n=1000 vertices, 249995 edges)
- **Graph 4**: Default input 1 (n=7 vertices, 7 edges)
- **Graph 5**: Default input 2 (n=5 vertices, 5 edges)

#### Performance Results Summary:

| Graph | Vertices | Edges | Algorithm | Total Cost | Operations | Time (ms) |
|-------|----------|-------|-----------|------------|------------|-----------|
| 1 | 100 | 2,466 | Prim | 305 | 1,565 | 3.28 |
| 1 | 100 | 2,466 | Kruskal | 305 | 5,965 | 5.01 |
| 2 | 500 | 62,431 | Prim | 548 | 10,806 | 34.09 |
| 2 | 500 | 62,431 | Kruskal | 548 | 130,965 | 17.72 |
| 3 | 1,000 | 249,995 | Prim | 1,003 | 29,003 | 71.89 |
| 3 | 1,000 | 249,995 | Kruskal | 1,003 | 512,265 | 19.71 |
| 4 | 7 | 7 | Prim | 16 | 30 | 0.01 |
| 4 | 7 | 7 | Kruskal | 16 | 39 | 0.05 |
| 5 | 5 | 5 | Prim | 6 | 18 | 0.00 |
| 5 | 5 | 5 | Kruskal | 6 | 29 | 0.00 |

### 2. Comparison Between Prim's and Kruskal's Algorithms

#### Time Complexity Analysis:
- **Prim's Algorithm**: O(E log V) using binary heap/priority queue
- **Kruskal's Algorithm**: O(E log E) due to sorting edges

#### Key Observations:

**Operation Count:**
- Prim's algorithm consistently uses fewer operations across all test cases
- For small graphs (n=5-7): Prim (18-30 ops) vs Kruskal (29-39 ops)
- For large graphs (n=1000): Prim (29,003 ops) vs Kruskal (512,265 ops) - **17x difference**

**Execution Time:**
- Small graphs: Prim is slightly faster (0.01ms vs 0.05ms for n=7)
- Medium-large graphs: Kruskal becomes faster despite higher operation count
- n=500: Prim (34.09ms) vs Kruskal (17.72ms) - Kruskal **48% faster**
- n=1000: Prim (71.89ms) vs Kruskal (19.71ms) - Kruskal **73% faster**

**Memory Efficiency:**
- Prim's algorithm maintains adjacency lists and priority queues
- Kruskal's algorithm requires edge sorting and union-find data structures

#### Graph Density Impact:
The test graphs appear to be relatively dense (high edge-to-vertex ratio):
- Graph 1: ~246 edges per vertex (very dense)
- Graph 2: ~125 edges per vertex (dense)
- Graph 3: ~250 edges per vertex (very dense)

### 3. Conclusions and Recommendations

#### Prim's Algorithm is Preferable When:
1. **Graphs are sparse** (E ≈ V)
2. **Real-time applications** where consistent performance is needed
3. **Memory constraints** exist (avoids storing all edges)
4. **Small to medium graphs** where implementation simplicity matters

#### Kruskal's Algorithm is Preferable When:
1. **Graphs are dense** (E ≈ V²) - as demonstrated in our tests
2. **Large-scale graphs** where parallel processing of edges is possible
3. **Edges are already sorted** or can be pre-sorted
4. **Disconnected components** need to be handled naturally

#### Performance Trade-offs:
- **Prim's** has better theoretical operation count but higher constant factors
- **Kruskal's** benefits from efficient sorting algorithms and cache performance
- The union-find data structure in Kruskal's is highly optimized in practice

#### Implementation Complexity:
- **Prim's**: Moderate complexity with priority queue management
- **Kruskal's**: Simpler conceptually but requires union-find implementation

### 4. Build && Run
### Build
```bash
mvn clean package
```

### Run
```bash
java -jar target/DAALab03-1.0-SNAPSHOT.jar
```

### 5. References

  GeeksforGeeks. (n.d.). *Kruskal's Minimum Spanning Tree (MST) Algorithm*. Retrieved from
https://www.geeksforgeeks.org/dsa/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/

  GeeksforGeeks. (n.d.). *Prim's Minimum Spanning Tree (MST) | Greedy Algo-5*. Retrieved from
https://www.geeksforgeeks.org/dsa/prims-minimum-spanning-tree-mst-greedy-algo-5/
