package by.kurilo.grapheditor.graphelements.edge;

import by.kurilo.grapheditor.graphelements.vertex.Vertex;

public class Edge {
   private Vertex from;
   private Vertex to;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }
}
