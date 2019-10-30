package test;

import graphs.DirectedAlGraph;

public class TestGraphs
{
    public static void main(String[] args)
    {
        //generate a new graph
        DirectedAlGraph<Character> letterGraph = new DirectedAlGraph<>();
        letterGraph.addVertices('a', 'b', 'c', 'd');

        for (char character : letterGraph.vertices())
        {
            char upperCharacter = (char)(character - 32);
            letterGraph.addVertex(upperCharacter);
        }
    }
}
