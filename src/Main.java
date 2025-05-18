public class Main {
    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);

        graph.addEdge(A, B, 5.0);
        graph.addEdge(B, C, 2.0);
        graph.addEdge(A, C, 10.0);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, A);
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, A);

        System.out.println("Dijkstra path from A to C: " + dijkstra.pathTo(C));
        System.out.println("BFS path from A to C: " + bfs.pathTo(C));
    }
}
