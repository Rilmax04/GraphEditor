package by.kurilo.grapheditor.iterator.graphiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.*;

public class GraphIterator<T> {
    private DirectedGraph<T> graph;

    public GraphIterator(DirectedGraph<T> graph) {
        this.graph = graph;
    }

    public ListIterator<Vertex<T>> vertexIterator() {
        return new ArrayList<>(graph.getVertices().values()).listIterator();
    }

    public ListIterator<Edge<T>> edgeIterator() {
        List<Edge<T>> edges = new ArrayList<>();
        for (Vertex<T> vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        return edges.listIterator();
    }

    public ListIterator<Vertex<T>> reverseVertexIterator() {
        return new ArrayList<>(graph.getVertices().values()).listIterator(graph.getVertices().size());
    }

    public ListIterator<Edge<T>> reverseEdgeIterator() {
        List<Edge<T>> edges = new ArrayList<>();
        for (Vertex<T> vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        Collections.reverse(edges);
        return edges.listIterator();
    }

    public ListIterator<Vertex<T>> constantVertexIterator() {
        return Collections.unmodifiableList(new ArrayList<>(graph.getVertices().values())).listIterator();
    }

    public ListIterator<Edge<T>> constantEdgeIterator() {
        List<Edge<T>> edges = new ArrayList<>();
        for (Vertex<T> vertex : graph.getVertices().values()) {
            edges.addAll(vertex.getOutgoingEdges());
        }
        return Collections.unmodifiableList(edges).listIterator();
    }

    public void removeVertexByIterator(ListIterator<Vertex<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex<T> vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void removeEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge<T> edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void removePreviousVertexByIterator(ListIterator<Vertex<T>> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Vertex<T> vertexToRemove = iterator.previous();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void removePreviousEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Edge<T> edgeToRemove = iterator.previous();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void constantRemoveVertexByIterator(ListIterator<Vertex<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex<T> vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void constantRemoveEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge<T> edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void reverseRemoveVertexByIterator(ListIterator<Vertex<T>> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Vertex<T> vertexToRemove = iterator.previous();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }

    public void reverseRemoveEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasPrevious()) {
            Edge<T> edgeToRemove = iterator.previous();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }
}