package by.kurilo.grapheditor.DirectedGraph;

import by.kurilo.grapheditor.directedgraph.DirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    private DirectedGraph graph;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        graph = new DirectedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testAddVertex() {
        graph.addVertex("D");
        assertNotNull(graph.getVertex("D"));
        assertEquals(4, graph.getVertices().size());
    }

    @Test
    void testAddEdge() {
        graph.addEdge("A", "B");
        assertEquals(2, graph.getOutDegree("A"));
        assertEquals(2, graph.getInDegree("B"));
    }

    @Test
    void testRemoveVertex() {
        graph.removeVertex("B");
        assertNull(graph.getVertex("B"));
        assertEquals(2, graph.getVertices().size());
    }

    @Test
    void testRemoveEdge() {
        graph.addEdge("A", "B");
        graph.removeEdge("A", "B");
        assertEquals(1, graph.getOutDegree("A"));
        assertEquals(1, graph.getInDegree("B"));
    }

    @Test
    void testIsFoundVertex() {
        assertTrue(graph.isFoundVertex("A"));
        assertTrue(graph.isFoundVertex("B"));
        assertFalse(graph.isFoundVertex("D"));
    }

    @Test
    void testIsFoundEdge() {
        assertTrue(graph.isFoundEdge("A", "B"));
        assertTrue(graph.isFoundEdge("B", "C"));
        assertFalse(graph.isFoundEdge("C", "A"));
        assertFalse(graph.isFoundEdge("A", "C"));
    }

    @Test
    void testCountVertex() {
        graph.countVertex();
        assertEquals(3, graph.getVertices().size());
        graph.addVertex("D");
        graph.countVertex();
        assertEquals(4, graph.getVertices().size());
    }


    @Test
    void testCountEdge() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
       /* int totalEdges = graph.getVertices().values().stream()
                .mapToInt(v -> v.getOutgoingEdges().size())
                .sum();
        assertEquals(4, totalEdges);*/
    }
    @Test
    void testShowGraph() {
        graph.showGraph();
        String expectedOutput = "A -> B \n" +
                "B -> C \n" +
                "C ->";

        assertEquals(expectedOutput.replace("\n", System.lineSeparator()),
                outputStreamCaptor.toString().trim());
    }
    @Test
    void testCountEdgeWithEdges() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");

        assertEquals(5, graph.countEdge());
    }
}