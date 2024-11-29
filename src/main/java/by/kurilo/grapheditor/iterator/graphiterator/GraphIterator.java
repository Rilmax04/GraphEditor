package by.kurilo.grapheditor.iterator.graphiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.*;

public class GraphIterator {
    private DirectedGraph graph;

    public GraphIterator(DirectedGraph graph) {
        this.graph = graph;
    }

    public ListIterator<Vertex> vertexIterator() {
        return new ArrayList<>(graph.getVertices().values()).listIterator();
    }

    public ListIterator<Edge> edgeIterator() {
        List<Edge> edges = new ArrayList<>();
        for (Vertex vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        return edges.listIterator();
    }

    public ListIterator<Vertex> reverseVertexIterator() {
        return new ArrayList<>(graph.getVertices().values()).listIterator(graph.getVertices().size());
    }

    public ListIterator<Edge> reverseEdgeIterator() {
        List<Edge> edges = new ArrayList<>();
        for (Vertex vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        Collections.reverse(edges);
        return edges.listIterator();
    }

    public ListIterator<Vertex> constantVertexIterator() {
        return Collections.unmodifiableList(new ArrayList<>(graph.getVertices().values())).listIterator();
    }

    public ListIterator<Edge> constantEdgeIterator() {
        List<Edge> edges = new ArrayList<>();
        for (Vertex vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        return Collections.unmodifiableList(edges).listIterator();
    }

    public void removeVertexByIterator(ListIterator<Vertex> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void removeEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void removePreviousVertexByIterator(ListIterator<Vertex> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Vertex vertexToRemove = iterator.previous();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void removePreviousEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Edge edgeToRemove = iterator.previous();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void constantRemoveVertexByIterator(ListIterator<Vertex> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void constantRemoveEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void reverseRemoveVertexByIterator(ListIterator<Vertex> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Vertex vertexToRemove = iterator.previous();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void reverseRemoveEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Edge edgeToRemove = iterator.previous();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }
}