package by.kurilo.grapheditor.iterator.incidentiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class IncidentIteratorTest {

    private DirectedGraph<String> graph;
    private IncidentIterator<String> incidentIterator;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        incidentIterator = new IncidentIterator<>(graph);
    }

    @Test
    void testIncidentEdgeIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentEdgeIterator("A");
        assertTrue(iterator.hasNext());

        Edge<String> firstEdge = iterator.next();
        assertNotNull(firstEdge);
        assertEquals("A", firstEdge.getFrom().getName());
        assertTrue(firstEdge.getTo().getName().matches("B|C"));
    }

    @Test
    void testAdjacentVertexIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentVertexIterator("A");
        assertTrue(iterator.hasNext());

        Vertex<String> firstVertex = iterator.next();
        assertNotNull(firstVertex);
        assertTrue(firstVertex.getName().matches("B|C"));
    }

    @Test
    void testIncidentReverseEdgeIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentReverseEdgeIterator("A");
        assertTrue(iterator.hasNext());

        Edge<String> lastEdge = iterator.next();
        assertNotNull(lastEdge);
        assertEquals("A", lastEdge.getFrom().getName());
        assertTrue(lastEdge.getTo().getName().matches("B|C"));
    }

    @Test
    void testAdjacentReverseVertexIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentReverseVertexIterator("A");
        assertTrue(iterator.hasNext());

        Vertex<String> lastVertex = iterator.next();
        assertNotNull(lastVertex);
        assertTrue(lastVertex.getName().matches("B|C"));
    }

    @Test
    void testIncidentConstantEdgeIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentConstantEdgeIterator("A");
        assertThrows(UnsupportedOperationException.class, () -> {
            iterator.next();
            iterator.remove();
        });
    }

    @Test
    void testAdjacentConstantVertexIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentConstantVertexIterator("A");
        assertThrows(UnsupportedOperationException.class, () -> {
            iterator.next();
            iterator.remove();
        });
    }

    @Test
    void testReverseRemoveEdgeByIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentReverseEdgeIterator("A");
        iterator.next();
        incidentIterator.reverseRemoveEdgeByIterator(iterator);
        assertEquals(1, graph.countEdge());
    }

    @Test
    void testReverseRemoveVertexByIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentReverseVertexIterator("A");
        iterator.next();
        incidentIterator.reverseRemoveVertexByIterator(iterator);
        assertEquals(2, graph.getVertices().size());
    }

    @Test
    void testEmptyIncidentEdgeIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentEdgeIterator("D");
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEmptyAdjacentVertexIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentVertexIterator("D");
        assertFalse(iterator.hasNext());
    }
    @Test
    void testConstantRemoveEdgeByIterator() {
        ListIterator<Edge<String>> iterator = incidentIterator.incidentEdgeIterator("A");

        assertEquals(2, graph.countEdge());

        incidentIterator.constantRemoveEdgeByIterator(iterator);

        assertEquals(1, graph.countEdge());

        assertTrue(graph.isFoundEdge("A", "B") || graph.isFoundEdge("A", "C"));
    }

    @Test
    void testConstantRemoveVertexByIterator() {
        ListIterator<Vertex<String>> iterator = incidentIterator.adjacentVertexIterator("A");

        assertEquals(3, graph.getVertices().size());

        incidentIterator.constantRemoveVertexByIterator(iterator);

        assertEquals(2, graph.getVertices().size());

        assertTrue(graph.isFoundVertex("B") || graph.isFoundVertex("C"));
    }
}