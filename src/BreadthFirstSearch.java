import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Set<Vertex<V>> marked = new HashSet<>();
    private Vertex<V> source;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> s) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.contains(vertex);
    }

    @Override
    public List<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) return null;
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> x = vertex; edgeTo.containsKey(x); x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(edgeTo.containsKey(vertex) ? edgeTo.get(vertex) : vertex);
        Collections.reverse(path);
        return path;
    }

}
