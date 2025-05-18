import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        map.get(source).add(dest);
        // For undirected graph, also add: dest.addAdjacentVertex(source, weight);
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }

    public Map<Vertex<V>, List<Vertex<V>>> getMap() {
        return map;
    }
}
