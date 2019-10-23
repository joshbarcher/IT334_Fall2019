package graphs;

import java.util.Set;

public interface IGraph<V>
{
    //insertion...
    void addVertex(V vertex);
    void addEdge(Edge<V> edge);
    void addVertices(V... vertices);
    void addEdges(Edge<V>... edges);

    //removal...
    void removeVertex(V vertex);
    void removeEdge(Edge<V> edge);
    void clear();

    //read...
    Set<V> vertices();
    Set<Edge<V>> edges();

    //find...
    boolean containsVertex(V vertex);
    boolean containsEdge(Edge<V> edge);

    int vertexSize();
    int edgeSize();
}











