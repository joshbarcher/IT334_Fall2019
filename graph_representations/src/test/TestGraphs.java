package test;

import graphs.DirectedAlGraph;
import graphs.Edge;

import java.util.Set;

public class TestGraphs
{
    public static void main(String[] args)
    {
        //generate a new graph
        DirectedAlGraph<Character> letterGraph = new DirectedAlGraph<>();
        letterGraph.addVertices('a', 'b', 'c', 'd', 'e');
        letterGraph.addEdges(
            new Edge<>('a', 'b'),
            new Edge<>('a', 'c'),
            new Edge<>('a', 'e'),
            new Edge<>('b', 'c'),
            new Edge<>('c', 'd'),
            new Edge<>('c', 'e'),
            new Edge<>('d', 'a'),
            new Edge<>('d', 'b'),
            new Edge<>('d', 'e')
        );

        Set<Character> vertices = letterGraph.vertices();
        Set<Edge<Character>> edges = letterGraph.edges();

        boolean hasA = letterGraph.containsVertex('a'); //should be true
        boolean hasF = letterGraph.containsVertex('f'); //should be false

        boolean hasAB = letterGraph.containsEdge(new Edge<>('a', 'b')); //should be true
        boolean hasAF = letterGraph.containsEdge(new Edge<>('a', 'f')); //should be false

        //all of the following should throw an exception
        letterGraph.addEdge(new Edge<>('a', 'a')); //self-loop
        letterGraph.addEdge(new Edge<>('f', 'g')); //missing vertex
        letterGraph.addEdge(new Edge<>('a', 'c')); //duplicate edge
    }
}
