package sample;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTeste {
    private Pair<String, String> direction = new Pair<>("a", "b");
    private Pair<String, String> direction2 = new Pair<>("a", "v");
    private Graph graph = new Graph();

    private Arcs arcs = new Arcs(direction, 12);
    private Arcs arcs2 = new Arcs(direction2, 22);

    private String vertice1 = "vertice1";
    private String vertice2 = "vertice2";


    @org.junit.jupiter.api.Test
    void addVertices() {
        graph.addVertices(vertice1);
        assertTrue(graph.getVertices().contains(vertice1));
        assertFalse(graph.getVertices().contains(vertice2));
    }

    @org.junit.jupiter.api.Test
    void addArc() {
      graph.addArc(arcs);
      graph.addArc(arcs2);
      assertEquals(graph.getArc().get(0), arcs);
      assertTrue(graph.getArc().contains(arcs2));
    }

    @org.junit.jupiter.api.Test
    void removeVer() {
        graph.addVertices(vertice1);
        graph.addVertices(vertice2);
        assertTrue(graph.getVertices().contains(vertice2));
        graph.removeVer(vertice2);
        assertFalse(graph.getVertices().contains(vertice2));
    }

    @org.junit.jupiter.api.Test
    void removeArc() {

        arcs = new Arcs(new Pair<>("a", "b"), 22);
        graph.addArc(arcs);
        graph.addArc(arcs2);
        graph.removeArc("a", "b");
        assertFalse(graph.getArc().contains(arcs));
        assertTrue(graph.getArc().contains(arcs2));
    }

    @org.junit.jupiter.api.Test
    void renameVertex() {
        graph.addVertices(vertice2);
        graph.renameVertex("ver3", vertice2);
        assertTrue(graph.getVertices().contains("ver3"));
        assertFalse(graph.getVertices().contains(vertice2));
    }

    @org.junit.jupiter.api.Test
    void renameWeight() {
        Arcs otherArc = new Arcs(new Pair<>("b", "c"), 10);
        Graph otherGraph = new Graph();
        otherGraph.addArc(otherArc);
        otherGraph.renameWeight("b","c", 20);
        assertEquals(20, otherArc.getWeight());
    }

    @org.junit.jupiter.api.Test
    void listArcs1() {
        Arcs arcs1 = new Arcs(new Pair<>("a", "b") ,1);
        Arcs arcs2 = new Arcs(new Pair<>("a", "c") ,2);
        Arcs arcs3 = new Arcs(new Pair<>("a", "d") ,3);
        graph.addArc(arcs1);
        graph.addArc(arcs2);
        graph.addArc(arcs3);
        var listArcs1 = graph.listArcs1("a");

        StringBuilder result = new StringBuilder(listArcs1.get(0).getDirection().getValue());
        for (int i = 1; i < listArcs1.size(); i++)
            result.append("; ").append(listArcs1.get(i).getDirection().getValue());

        assertEquals(result.toString(), "b; c; d");

    }

    @Test
    void listArcs2() {
        Arcs arcs1 = new Arcs(new Pair<>("x", "a") ,1);
        Arcs arcs2 = new Arcs(new Pair<>("y", "a") ,2);
        Arcs arcs3 = new Arcs(new Pair<>("z", "a") ,3);
        graph.addArc(arcs1);
        graph.addArc(arcs2);
        graph.addArc(arcs3);
        var listArcs2 = graph.listArcs2("a");

        StringBuilder result = new StringBuilder(listArcs2.get(0).getDirection().getKey());
        for (int i = 1; i < listArcs2.size(); i++)
            result.append("; ").append(listArcs2.get(i).getDirection().getKey());

        assertEquals(result.toString(), "x; y; z");
    }
}