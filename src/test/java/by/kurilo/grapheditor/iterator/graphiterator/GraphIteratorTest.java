package by.kurilo.grapheditor.iterator.graphiterator;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import by.kurilo.grapheditor.graphelements.edge.Edge;
import by.kurilo.grapheditor.graphelements.vertex.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class GraphIteratorTest {

    private DirectedGraph<String> graph;
    private GraphIterator<String> graphIterator;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graphIterator = new GraphIterator<>(graph);
    }

    @Test
    void testVertexIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.vertexIterator();

        assertTrue(vertexIterator.hasNext());
        Vertex<String> firstVertex = vertexIterator.next();
        assertNotNull(firstVertex);
        assertTrue(firstVertex.getName().matches("A|B|C"));
    }

    @Test
    void testEdgeIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.edgeIterator();

        assertTrue(edgeIterator.hasNext());
        Edge<String> firstEdge = edgeIterator.next();
        assertNotNull(firstEdge);
        assertEquals("A", firstEdge.getFrom().getName());
        assertTrue(firstEdge.getTo().getName().matches("B|C"));
    }

    @Test
    void testReverseVertexIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.reverseVertexIterator();

        assertTrue(vertexIterator.hasPrevious());
        Vertex<String> lastVertex = vertexIterator.previous();

        assertNotNull(lastVertex);
        assertTrue(lastVertex.getName().matches("A|B|C"));
    }

    @Test
    void testReverseEdgeIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.reverseEdgeIterator();

        assertTrue(edgeIterator.hasNext());
        Edge<String> firstEdge = edgeIterator.next();
        assertNotNull(firstEdge);
        assertEquals("A", firstEdge.getFrom().getName());
        assertTrue(firstEdge.getTo().getName().matches("C|B"));
    }

    @Test
    void testConstantVertexIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.constantVertexIterator();

        assertTrue(vertexIterator.hasNext());
        Vertex<String> firstVertex = vertexIterator.next();
        assertNotNull(firstVertex);
        assertTrue(firstVertex.getName().matches("A|B|C"));
    }

    @Test
    void testConstantEdgeIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.constantEdgeIterator();

        assertTrue(edgeIterator.hasNext());
        Edge<String> firstEdge = edgeIterator.next();
        assertNotNull(firstEdge);
        assertEquals("A", firstEdge.getFrom().getName());
        assertTrue(firstEdge.getTo().getName().matches("B|C"));
    }

    @Test
    void testRemoveVertexByIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.vertexIterator();
        vertexIterator.next();
        graphIterator.removeVertexByIterator(vertexIterator);

        assertEquals(2, graph.getVertices().size());
    }

    @Test
    void testRemoveEdgeByIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.edgeIterator();
        edgeIterator.next();
        graphIterator.removeEdgeByIterator(edgeIterator);

        assertEquals(1, graph.countEdge());
    }

    @Test
    void testRemovePreviousVertexByIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.vertexIterator();
        vertexIterator.next();
        graphIterator.removePreviousVertexByIterator(vertexIterator);
        assertEquals(2, graph.getVertices().size());
    }

    @Test
    void testRemovePreviousEdgeByIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.edgeIterator();
        edgeIterator.next();
        graphIterator.removePreviousEdgeByIterator(edgeIterator);
        assertEquals(1, graph.countEdge());
    }

    @Test
    void testConstantRemoveVertexByIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.constantVertexIterator();
        vertexIterator.next();
        assertThrows(UnsupportedOperationException.class, () -> graphIterator.constantRemoveVertexByIterator(vertexIterator));
        assertEquals(3, graph.getVertices().size());
    }

    @Test
    void testConstantRemoveEdgeByIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.constantEdgeIterator();
        edgeIterator.next();

        assertThrows(UnsupportedOperationException.class, () -> graphIterator.constantRemoveEdgeByIterator(edgeIterator));

        assertEquals(2, graph.countEdge());
    }

    @Test
    void testReverseRemoveVertexByIterator() {
        ListIterator<Vertex<String>> vertexIterator = graphIterator.reverseVertexIterator();
        vertexIterator.previous();
        graphIterator.reverseRemoveVertexByIterator(vertexIterator);

        assertEquals(2, graph.getVertices().size());
    }

    @Test
    void testReverseRemoveEdgeByIterator() {
        ListIterator<Edge<String>> edgeIterator = graphIterator.reverseEdgeIterator();
        edgeIterator.next();
        graphIterator.reverseRemoveEdgeByIterator(edgeIterator);

        assertEquals(1, graph.countEdge());
    }

    @Test
    void testEmptyGraphIteration() {
        DirectedGraph<String> emptyGraph = new DirectedGraph<>();
        GraphIterator<String> emptyIterator = new GraphIterator<>(emptyGraph);

        assertFalse(emptyIterator.vertexIterator().hasNext());
    }
}