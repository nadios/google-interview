package com.nadia.crackcode.ch4;

import com.nadia.crackcode.utils.search.Graph;
import com.nadia.crackcode.utils.search.Node;

import java.util.LinkedList;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 */
public class Task4_2 {

    public static void main(String[] args) {
        Graph g = Graph.createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[2];
        Node end = n[3];
        System.out.println(search(g, start, end));
    }

    public static Boolean search(Graph g, Node start, Node fin) {
        if (start == fin) return true;
        LinkedList q = new LinkedList();
        start.state = Node.State.Visiting;
        q.add(start);
        while (q.size() > 0) {
            Node node = (Node) q.remove(q.size() - 1);
            if (node != null) {
                Node[] nodes = node.getAdjacent();
                for (Node child : nodes) {
                    if (child.state == Node.State.Unvisited) {
                        if (child == fin) {
                            return true;
                        } else {
                            child.state = Node.State.Visiting;
                            q.add(child);
                        }
                    }
                }
                node.state = Node.State.Visited;
            }

        }
        return false;
    }


}
