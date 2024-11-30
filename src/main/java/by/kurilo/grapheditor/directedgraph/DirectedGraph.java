package by.kurilo.grapheditor.directedgraph;

import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.*;

public class DirectedGraph<T> {
    private Map<String, Vertex<T>> vertices;

    public DirectedGraph() {
        this.vertices = new HashMap<>();
    }

    public boolean isFoundVertex(String name) {
        if (vertices.containsKey(name)) {
            System.out.println("The vertex " + name + " is present in the graph");
            return true;
        } else {
            System.out.println("The vertex " + name + " isn't present in the graph");
            return false;
        }
    }

    public boolean isFoundEdge(String fromName, String toName) {
        Vertex<T> fromVertex = vertices.get(fromName);
        if (fromVertex != null) {
            for (Edge<T> edge : fromVertex.getOutgoingEdges()) {
                if (edge.getTo().getName().equals(toName)) {
                    System.out.println("The edge " + fromName + " -> " + toName + " is present in the graph");
                    return true;
                }
            }
        }
        System.out.println("The edge " + fromName + " -> " + toName + " isn't present in the graph");
        return false;
    }

    public void countVertex() {
        System.out.println("Graph has " + vertices.size() + " vertex" + (vertices.size() != 1 ? "es" : ""));
    }

    public int countEdge() {
        int countEdge = 0;
        for (Vertex<T> vertex : vertices.values())
            countEdge += vertex.getOutgoingEdges().size();

        return countEdge;
    }

    public void addVertex(T name) {
        if (!vertices.containsKey(name)) {
            vertices.put(name.toString(), new Vertex<>(name));
        }
    }

    public void removeVertex(T vertexName) {
        Vertex<T> vertexToRemove = vertices.get(vertexName.toString());
        if (vertexToRemove == null) return;

        for (Vertex<T> v : vertices.values()) {
            v.getOutgoingEdges().removeIf(edge -> edge.getTo().getName().equals(vertexToRemove.getName()));
        }

        vertices.remove(vertexName.toString());
        System.out.println("Vertex " + vertexName + " has been removed from the graph");
    }

    public int getInDegree(T vertexName) {
        Vertex<T> vertex = vertices.get(vertexName.toString());
        if (vertex != null)
            return vertex.getIncomingEdges().size();
        else return -1;
    }

    public int getOutDegree(T vertexName) {
        Vertex<T> vertex = vertices.get(vertexName.toString());
        if (vertex != null)
            return vertex.getOutgoingEdges().size();
        else return -1;
    }

    public Vertex<T> getVertex(T name) {
        return vertices.get(name.toString());
    }

    public void addEdge(T fromName, T toName) {
        Vertex<T> from = getVertex(fromName);
        Vertex<T> to = getVertex(toName);

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both vertices not found.");
        }

        Edge<T> edge = new Edge<>(from, to);
        from.addOutgoingEdge(edge);
        to.addIncomingEdge(edge);
    }

    public void removeEdge(T fromName, T toName) {
        Vertex<T> from = getVertex(fromName);
        Vertex<T> to = getVertex(toName);

        Edge<T> edgeToRemove = null;
        for (Edge<T> edge : from.getOutgoingEdges()) {
            if (edge.getTo() == to) {
                edgeToRemove = edge;
                break;
            }
        }

        if (edgeToRemove != null) {
            from.getOutgoingEdges().remove(edgeToRemove);
            to.getIncomingEdges().remove(edgeToRemove);
        }
    }

    public void showGraph() {
        for (Vertex<T> vertex : vertices.values()) {
            System.out.print(vertex.getName() + " -> ");
            for (Edge<T> edge : vertex.getOutgoingEdges()) {
                System.out.print(edge.getTo().getName() + " ");
            }
            System.out.println();
        }
    }

    public Map<String, Vertex<T>> getVertices() {
        return vertices;
    }
}