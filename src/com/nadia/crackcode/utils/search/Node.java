package com.nadia.crackcode.utils.search;

/**
 * Graph node
 */
public class Node {
    public enum State {
        Unvisited, Visited, Visiting;
    }

    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public State state;

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Node[adjacentLength];
        state = State.Unvisited;
    }

    public void addAdjacent(Node x) {
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }
}
