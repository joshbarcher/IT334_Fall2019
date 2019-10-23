package graphs;

public class Edge<V>
{
    private V source;
    private V dest;

    public Edge(V source, V dest)
    {
        this.source = source;
        this.dest = dest;
    }

    public V getSource()
    {
        return source;
    }

    public void setSource(V source)
    {
        this.source = source;
    }

    public V getDest()
    {
        return dest;
    }

    public void setDest(V dest)
    {
        this.dest = dest;
    }

    @Override
    public String toString()
    {
        return "Edge{" +
                "source=" + source +
                ", dest=" + dest +
                '}';
    }
}
