package org.example.graph;

import javax.swing.text.html.Option;
import java.util.*;

public class BFS<T> {

    public static<T> Optional<Node<T>> search(T goal, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        // Can I continue expanding?
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Visiting: " + currentNode.getValue());

            // if im on Goal
            if (currentNode.getValue().equals(goal)) {
                return Optional.of(currentNode);
            } else {
                closed.add(currentNode); // explored items
                queue.addAll(currentNode.getNeighbors()); // successors
                queue.removeAll(closed);
            }
        }

        return Optional.empty();
    }
}
