package by.kurilo.grapheditor.graphelements.vertex;

import by.kurilo.grapheditor.graphelements.edge.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    private Vertex vertexA;
    private Vertex vertexB;

    @BeforeEach
    void setUp() {
        vertexA = new Vertex("A");
        vertexB = new Vertex("B");
    }

    @Test
    void testGetName() {
        assertEquals("A", vertexA.getName());
        assertEquals("B", vertexB.getName());
    }

    @Test
    void testAddOutgoingEdge() {
        Edge edge = new Edge(vertexA, vertexB);
        vertexA.addOutgoingEdge(edge);

        List<Edge> outgoingEdges = vertexA.getOutgoingEdges();
        assertEquals(1, outgoingEdges.size());
        assertEquals(vertexB, outgoingEdges.get(0).getTo());
    }

    @Test
    void testAddIncomingEdge() {
        Edge edge = new Edge(vertexB, vertexA);
        vertexA.addIncomingEdge(edge);

        List<Edge> incomingEdges = vertexA.getIncomingEdges();
        assertEquals(1, incomingEdges.size());
        assertEquals(vertexB, incomingEdges.get(0).getFrom());
    }

    @Test
    void testMultipleOutgoingEdges() {
        Edge edge1 = new Edge(vertexA, vertexB);
        Edge edge2 = new Edge(vertexA, new Vertex("C"));

        vertexA.addOutgoingEdge(edge1);
        vertexA.addOutgoingEdge(edge2);

        List<Edge> outgoingEdges = vertexA.getOutgoingEdges();
        assertEquals(2, outgoingEdges.size());
    }

    @Test
    void testMultipleIncomingEdges() {
        Edge edge1 = new Edge(vertexB, vertexA);
        Edge edge2 = new Edge(new Vertex("C"), vertexA);

        vertexA.addIncomingEdge(edge1);
        vertexA.addIncomingEdge(edge2);

        List<Edge> incomingEdges = vertexA.getIncomingEdges();
        assertEquals(2, incomingEdges.size());
    }

    @Test
    void testEmptyEdges() {
        assertTrue(vertexA.getOutgoingEdges().isEmpty());
        assertTrue(vertexA.getIncomingEdges().isEmpty());
    }
}
