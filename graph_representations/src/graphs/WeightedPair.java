package graphs;

import java.util.Objects;

public class WeightedPair<V> implements Comparable<WeightedPair<V>>
{
    private V vertex;
    private double label;

    public WeightedPair(V vertex, double label)
    {
        this.vertex = vertex;
        this.label = label;
    }

    @Override
    public int compareTo(WeightedPair<V> other)
    {
        if (label == other.label)
        {
            return 0;
        }
        else if (label > other.label)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedPair<?> that = (WeightedPair<?>) o;
        return Objects.equals(vertex, that.vertex);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(vertex);
    }

    public V getVertex()
    {
        return vertex;
    }

    public void setVertex(V vertex)
    {
        this.vertex = vertex;
    }

    public double getLabel()
    {
        return label;
    }

    public void setLabel(double label)
    {
        this.label = label;
    }

    @Override
    public String toString()
    {
        return "WeightedPair{" +
                "vertex=" + vertex +
                ", label=" + label +
                '}';
    }
}
