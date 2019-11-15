package graphs;

public class Edge<V>
{
    private V source;
    private V dest;
    private double weight;

    public Edge(V source, V dest, double weight)
    {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(V source, V dest)
    {
        this(source, dest, 1.0);
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

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
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
