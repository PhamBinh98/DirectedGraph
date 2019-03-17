package sample;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Arcs> arcsList = new ArrayList<Arcs>();
    private List<String> vertices = new ArrayList<String>();

    List<Arcs> getArc() {

        return this.arcsList;
    }

    List<String> getVertices() {
        return vertices;
    }

    public void addVertices(String ver) {
        this.vertices.add(ver);
    }

    public void addArc(Arcs arcs) {
        this.arcsList.add(arcs);
    }

    public void removeVer(String ver) {
        this.vertices.remove(ver);
    }

    public void removeArc(String a, String b) {
        for (Arcs arcs : arcsList) {
            if (arcs.getDirection().getKey().equals(a) && arcs.getDirection().getValue().equals(b)) {
                arcsList.remove(arcs);
            }
        }
    }

    public void renameVertex(String newname, String oldname) {
        for (String v : vertices) {
            if (v.equals(oldname)) {
                removeVer(oldname);
                addVertices(newname);
            }
        }

    }

    public void renameWeight(String BeginVertex, String EndVertex, int Newweight) {
        for (Arcs arcs : arcsList) {
            if (arcs.getDirection().getKey().equals(BeginVertex) && arcs.getDirection().getValue().equals(EndVertex)) {
                arcs.setWeight(Newweight);
            }
        }
    }

    public List<Arcs> listArcs1(String vertices) {
        List<Arcs> result = new ArrayList<>();
        for (Arcs arcs : arcsList) {
            if (arcs.getDirection().getKey().equals(vertices)) {
                result.add(arcs);
            }
        }
        return result;
    }




    List<Arcs> listArcs2(String EndVertex) {
        List<Arcs> result = new ArrayList<>();
        for (Arcs arcs : arcsList) {
            if (arcs.getDirection().getValue().equals(EndVertex)) {
                result.add(arcs);
            }
        }
        return result;
    }
}

