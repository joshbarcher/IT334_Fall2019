package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DirectedAlGraph<V> implements IGraph<V>
{
    private Map<V, Node> aLists;

    public DirectedAlGraph()
    {
        aLists = new HashMap<>();
    }

    @Override
    public void addVertex(V vertex)
    {
        //only add if the vertex is new
        if (!containsVertex(vertex))
        {
            //null list until an edge is added
            aLists.put(vertex, null);
        }
    }

    @Override
    public void addVertices(V... vertices)
    {
        //take each input vertex and add it
        //using our singular add() method
        for (V vertex : vertices)
        {
            addVertex(vertex);
        }
    }

    @Override
    public void addEdge(Edge<V> edge)
    {
        //prevent self loops
        if (edge.getSource().equals(edge.getDest()))
        {
            throw new IllegalArgumentException("No self loops allowed!");
        }

        //make sure the vertices exist
        if (!containsVertex(edge.getSource()))
        {
            throw new IllegalArgumentException("Source " + edge.getSource() +
                    " does not exist!");
        }
        else if (!containsVertex(edge.getDest()))
        {
            throw new IllegalArgumentException("Dest " + edge.getDest() +
                    " does not exist!");
        }

        //make sure the edge is new
        if (containsEdge(edge))
        {
            throw new IllegalArgumentException("Edge " + edge + " already exists");
        }

        //otherwise add the edge
        if (aLists.get(edge.getSource()) == null)
        {
            aLists.put(edge.getSource(), new Node(edge.getDest()));
        }
        else
        {
            Node oldHead = aLists.get(edge.getSource());
            Node newHead = new Node(edge.getDest(), oldHead);
            aLists.put(edge.getSource(), newHead);
        }
    }

    @Override
    public void addEdges(Edge<V>... edges)
    {
        for (Edge<V> edge : edges)
        {
            addEdge(edge);
        }
    }

    @Override
    public void removeVertex(V vertex)
    {

    }

    @Override
    public void removeEdge(Edge<V> edge)
    {

    }

    @Override
    public void clear()
    {

    }

    @Override
    public Set<V> vertices()
    {
        return null;
    }

    @Override
    public Set<Edge<V>> edges()
    {
        return null;
    }

    @Override
    public boolean containsVertex(V vertex)
    {
        return aLists.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(Edge<V> edge)
    {
        if (edge.getSource().equals(edge.getDest()))
        {
            return false;
        }

        //make sure the vertices exist
        if (!containsVertex(edge.getSource()) || !containsVertex(edge.getDest()))
        {
            return false;
        }

        //otherwise, search for the edge
        Node node = aLists.get(edge.getSource());
        while (node != null)
        {
            if (node.destVertex.equals(edge.getDest()))
            {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    @Override
    public int vertexSize()
    {
        //return the number of pairs in the map
        return aLists.size();
    }

    @Override
    public int edgeSize()
    {
        return 0;
    }

    private class Node
    {
        private V destVertex;
        private Node next;

        public Node(V vertex)
        {
            this(vertex, null);
        }

        public Node(V destVertex, Node next)
        {
            this.destVertex = destVertex;
            this.next = next;
        }
    }
}
