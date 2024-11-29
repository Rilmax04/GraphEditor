package by.kurilo.grapheditor.iterator.incidentiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class IncidentIterator {
    private DirectedGraph graph;

    public IncidentIterator(DirectedGraph graph) {
        this.graph = graph;
    }

    public ListIterator<Edge> incidentEdgeIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            return vertex.getOutgoingEdges().listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex> adjacentVertexIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            List<Vertex> adjacentVertices = new ArrayList<>();
            for (Edge e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            return adjacentVertices.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Edge> incidentReverseEdgeIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            List<Edge> edges = new ArrayList<>(vertex.getOutgoingEdges());
            Collections.reverse(edges); // Переворачиваем список рёбер
            return edges.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex> adjacentReverseVertexIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            List<Vertex> adjacentVertices = new ArrayList<>();
            for (Edge e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            Collections.reverse(adjacentVertices); // Переворачиваем список смежных вершин
            return adjacentVertices.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Edge> incidentConstantEdgeIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            return vertex.getOutgoingEdges().listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public ListIterator<Vertex> adjacentConstantVertexIterator(String vertexName) {
        Vertex vertex = graph.getVertex(vertexName);
        if (vertex != null) {
            List<Vertex> adjacentVertices = new ArrayList<>();
            for (Edge e : vertex.getOutgoingEdges()) {
                adjacentVertices.add(e.getTo());
            }
            return adjacentVertices.listIterator();
        } else {
            return Collections.emptyListIterator();
        }
    }

    public void constantRemoveEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge edgeToRemove = iterator.next();
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

    public void reverseRemoveEdgeByIterator(ListIterator<Edge> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Edge edgeToRemove = iterator.next();
            iterator.remove();
            graph.removeEdge(edgeToRemove.getFrom().getName(), edgeToRemove.getTo().getName());
        }
    }

    public void reverseRemoveVertexByIterator(ListIterator<Vertex> iterator) {
        if (iterator != null && iterator.hasNext()) {
            Vertex vertexToRemove = iterator.next();
            iterator.remove();
            graph.removeVertex(vertexToRemove.getName());
        }
    }
}