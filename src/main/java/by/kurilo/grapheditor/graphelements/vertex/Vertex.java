package by.kurilo.grapheditor.graphelements.vertex;

import by.kurilo.grapheditor.graphelements.edge.Edge;

import java.util.*;

public class Vertex {
    private final String name;
   private final List<Edge> outgoingEdges;
   private final List<Edge> incomingEdges;

    public Vertex(String name) {
        this.name = name;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
    }

    public void addOutgoingEdge(Edge edge) {
        outgoingEdges.add(edge);
    }

    public void addIncomingEdge(Edge edge) {
        incomingEdges.add(edge);
    }

    public List<Edge> getIncomingEdges() {
        return incomingEdges;
    }

    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }
    public String getName()
    {return name;}
}







