package by.kurilo.grapheditor.graphelements.vertex;

import by.kurilo.grapheditor.graphelements.edge.Edge;

import java.util.*;

public class Vertex<T> {
    private final T name;
    private final List<Edge<T>> outgoingEdges;
    private final List<Edge<T>> incomingEdges;

    public Vertex(T name) {
        this.name = name;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
    }

    public void addOutgoingEdge(Edge<T> edge) {
        outgoingEdges.add(edge);
    }

    public void addIncomingEdge(Edge<T> edge) {
        incomingEdges.add(edge);
    }

    public List<Edge<T>> getIncomingEdges() {
        return incomingEdges;
    }

    public List<Edge<T>> getOutgoingEdges() {
        return outgoingEdges;
    }

    public T getName() {
        return name;
    }
}