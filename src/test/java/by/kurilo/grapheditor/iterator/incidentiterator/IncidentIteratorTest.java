package by.kurilo.grapheditor.iterator.incidentiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;

public class IncidentIteratorTest {
    private DirectedGraph graph;
    private IncidentIterator incidentIterator;

    @BeforeEach
    public void setUp() {
        graph = new DirectedGraph();
        incidentIterator = new IncidentIterator(graph);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
    }

    @Test
    public void testIncidentEdgeIterator() {
        ListIterator<Edge> iterator = incidentIterator.incidentEdgeIterator("A");
        assertTrue(iterator.hasNext());
        Edge edge = iterator.next();
        assertEquals("B", edge.getTo().getName());
        edge = iterator.next();
        assertEquals("C", edge.getTo().getName());
    }

    @Test
    public void testAdjacentVertexIterator() {
        ListIterator<Vertex> iterator = incidentIterator.adjacentVertexIterator("A");
        assertTrue(iterator.hasNext());
        Vertex vertex = iterator.next();
        assertEquals("B", vertex.getName());
        vertex = iterator.next();
        assertEquals("C", vertex.getName());
    }

    @Test
    public void testIncidentReverseEdgeIterator() {
        ListIterator<Edge> iterator = incidentIterator.incidentReverseEdgeIterator("A");
        assertTrue(iterator.hasNext());
        Edge edge = iterator.next();
        assertEquals("C", edge.getTo().getName());
        edge = iterator.next();
        assertEquals("B", edge.getTo().getName());
    }

    @Test
    public void testAdjacentReverseVertexIterator() {
        ListIterator<Vertex> iterator = incidentIterator.adjacentReverseVertexIterator("A");
        assertTrue(iterator.hasNext());
        Vertex vertex = iterator.next();
        assertEquals("C", vertex.getName());
        vertex = iterator.next();
        assertEquals("B", vertex.getName());
    }

    @Test
    public void testIncidentConstantEdgeIterator() {
        ListIterator<Edge> iterator = incidentIterator.incidentConstantEdgeIterator("A");
        assertTrue(iterator.hasNext());
        Edge edge = iterator.next();
        assertEquals("B", edge.getTo().getName());
        edge = iterator.next();
        assertEquals("C", edge.getTo().getName());
    }

    @Test
    public void testAdjacentConstantVertexIterator() {
        ListIterator<Vertex> iterator = incidentIterator.adjacentConstantVertexIterator("A");
        assertTrue(iterator.hasNext());
        Vertex vertex = iterator.next();
        assertEquals("B", vertex.getName());
        vertex = iterator.next();
        assertEquals("C", vertex.getName());
    }

    @Test
    public void testConstantRemoveEdgeByIterator() {
        ListIterator<Edge> iterator = incidentIterator.incidentConstantEdgeIterator("A");
        incidentIterator.constantRemoveEdgeByIterator(iterator);
        assertEquals(1, graph.countEdge());
        incidentIterator.constantRemoveEdgeByIterator(iterator);
        assertEquals(0, graph.countEdge());
    }

    @Test
    public void testConstantRemoveVertexByIterator() {
        ListIterator<Vertex> iterator = incidentIterator.adjacentConstantVertexIterator("A");
        incidentIterator.constantRemoveVertexByIterator(iterator);
        assertNull(graph.getVertex("B"));
    }

    @Test
    public void testReverseRemoveEdgeByIterator() {
        ListIterator<Edge> iterator = incidentIterator.incidentReverseEdgeIterator("A");
        incidentIterator.reverseRemoveEdgeByIterator(iterator);
        assertEquals(1, graph.countEdge());
        incidentIterator.reverseRemoveEdgeByIterator(iterator);
        assertEquals(0, graph.countEdge());
    }

    @Test
    public void testReverseRemoveVertexByIterator() {
        ListIterator<Vertex> iterator = incidentIterator.adjacentReverseVertexIterator("A");
        incidentIterator.reverseRemoveVertexByIterator(iterator);
        assertNull(graph.getVertex("C"));
    }
}