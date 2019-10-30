package graphs;

import java.util.*;

public class DirectedAlGraph<V> implements IGraph<V>
{
    private Map<V, Node> aLists;
    private int edgeSize = 0;

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
        checkValidEdge(edge);

        edgeSize++;

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

    private void checkValidEdge(Edge<V> edge)
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
        //clear out adjacency lists
        aLists.clear();
        edgeSize = 0;
    }

    @Override
    public Set<V> vertices()
    {
        //create a new set to try and prevent
        //concurrent modification exceptions
        //in for loops outside this class
        return new HashSet<>(aLists.keySet());
    }

    @Override
    public Set<Edge<V>> edges()
    {
        Set<Edge<V>> results = new HashSet<>();

        //loop over all adjacency lists
        for (V vertex : aLists.keySet())
        {
            Node node = aLists.get(vertex);
            while (node != null)
            {
                Edge<V> edge = new Edge<>(vertex, node.destVertex);
                results.add(edge);
                node = node.next;
            }
        }

        return results;
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
        return edgeSize;
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
