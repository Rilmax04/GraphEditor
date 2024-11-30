package by.kurilo.grapheditor.iterator.incidentiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.*;

public class IncidentIterator<T> {
    private final DirectedGraph<T> graph;

    public IncidentIterator(DirectedGraph<T> graph) {
        this.graph = graph;
    }

    public ListIterator<Edge<T>> incidentEdgeIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            return vertex.getOutgoingEdges().listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex<T>> adjacentVertexIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            List<Vertex<T>> adjacentVertices = new ArrayList<>();
            for (Edge<T> e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            return adjacentVertices.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Edge<T>> incidentReverseEdgeIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            List<Edge<T>> edges = new ArrayList<>(vertex.getOutgoingEdges());
            Collections.reverse(edges);
            return edges.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex<T>> adjacentReverseVertexIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            List<Vertex<T>> adjacentVertices = new ArrayList<>();
            for (Edge<T> e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            Collections.reverse(adjacentVertices);
            return adjacentVertices.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Edge<T>> incidentConstantEdgeIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            return Collections.unmodifiableList(vertex.getOutgoingEdges()).listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex<T>> adjacentConstantVertexIterator(String vertexName) {
        Vertex<T> vertex = graph.getVertex((T) vertexName);
        if (vertex != null) {
            List<Vertex<T>> adjacentVertices = new ArrayList<>();
            for (Edge<T> e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            return Collections.unmodifiableList(adjacentVertices).listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public void constantRemoveEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge<T> edgeToRemove = iterator.next();
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

    public void reverseRemoveEdgeByIterator(ListIterator<Edge<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge<T> edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void reverseRemoveVertexByIterator(ListIterator<Vertex<T>> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex<T> vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }
}