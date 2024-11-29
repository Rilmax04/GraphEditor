package by.kurilo.grapheditor.graphelements.edge;

import by.kurilo.grapheditor.graphelements.vertex.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EdgeTest {

    @Test
    public void testEdgeCreation() {
        Vertex from = new Vertex("A");
        Vertex to = new Vertex("B");
        Edge edge = new Edge(from, to);

        assertNotNull(edge);
        assertEquals(from, edge.getFrom());
        assertEquals(to, edge.getTo());
    }

    @Test
    public void testGetFrom() {
        Vertex from = new Vertex("A");
        Vertex to = new Vertex("B");
        Edge edge = new Edge(from, to);

        assertEquals("A", edge.getFrom().getName());
    }

    @Test
   public void testGetTo() {
        Vertex from = new Vertex("A");
        Vertex to = new Vertex("B");
        Edge edge = new Edge(from, to);

        assertEquals("B", edge.getTo().getName());
    }
}
