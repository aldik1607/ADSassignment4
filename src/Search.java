import java.util.List;

public abstract class Search<V> {
    public abstract boolean hasPathTo(Vertex<V> vertex);

    public abstract List<Vertex<V>> pathTo(Vertex<V> vertex);
}
