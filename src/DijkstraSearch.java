import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        Comparator<Vertex<V>> comparator = Comparator.comparingDouble(distTo::get);
        pq = new PriorityQueue<>(comparator);

        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> u, Vertex<V> v, double weight) {
        if (distTo.get(v) > distTo.get(u) + weight) {
            distTo.put(v, distTo.get(u) + weight);
            edgeTo.put(v, u);
            pq.remove(v);  // update priority
            pq.add(v);
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return distTo.get(vertex) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = vertex; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }


}
