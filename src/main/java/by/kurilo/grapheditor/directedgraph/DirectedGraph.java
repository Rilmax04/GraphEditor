package by.kurilo.grapheditor.directedgraph;

import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.*;

public class DirectedGraph {
    private Map<String, Vertex> vertices;

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
        Vertex fromVertex = vertices.get(fromName);
        if (fromVertex != null) {
            for (Edge edge : fromVertex.getOutgoingEdges()) {
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
    public int countEdge()
    {
        int countEdge=0;
        for (Vertex vertex : vertices.values())
            countEdge+=vertex.getOutgoingEdges().size();

        return countEdge;

    }
    public void addVertex(String name) {
        if (!vertices.containsKey(name)) {
            vertices.put(name, new Vertex(name));
        }
    }

    public void removeVertex(String vertexName) {
        Vertex vertexToRemove = vertices.get(vertexName);
        if (vertexToRemove == null) return;

        for (Vertex v : vertices.values()) {
            v.getOutgoingEdges().removeIf(edge -> edge.getTo().equals(vertexToRemove));
        }

        vertices.remove(vertexName);
        System.out.println("Vertex " + vertexName + " has been removed from the graph");
    }
    public int getInDegree(String vertexName)
    {
        Vertex vertex=vertices.get(vertexName);
        if (vertex!=null)
            return vertex.getIncomingEdges().size();
        else return -1;
    }
    public int getOutDegree(String vertexName)
    {
        Vertex vertex=vertices.get(vertexName);
        if (vertex!=null)
            return vertex.getOutgoingEdges().size();
        else return -1;
    }

    public Vertex getVertex(String name) {
        return vertices.get(name);
    }

    public void addEdge(String fromName, String toName) {
        Vertex from = getVertex(fromName);
        Vertex to = getVertex(toName);

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both vertices not found.");
        }

        Edge edge = new Edge(from, to);
        from.addOutgoingEdge(edge);
        to.addIncomingEdge(edge);
    }

    public void removeEdge(String fromName, String toName) {
        Vertex from = getVertex(fromName);
        Vertex to = getVertex(toName);

        Edge edgeToRemove = null;
        for (Edge edge : from.getOutgoingEdges()) {
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
        for (Vertex vertex : vertices.values()) {
            System.out.print(vertex.getName() + " -> ");
            for (Edge edge : vertex.getOutgoingEdges()) {
                System.out.print(edge.getTo().getName() + " ");
            }
            System.out.println();
        }
    }

    public Map<String, Vertex> getVertices() {
        return vertices;
    }
}
