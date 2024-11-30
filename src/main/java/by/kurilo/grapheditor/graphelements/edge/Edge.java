package by.kurilo.grapheditor.graphelements.edge;

import by.kurilo.grapheditor.graphelements.vertex.Vertex;

public class Edge<T> {
    private final Vertex<T> from;
    private final Vertex<T> to;

    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }
}