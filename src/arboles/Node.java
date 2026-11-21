package arboles;

import java.util.ArrayList;
import java.util.List;

/**
 * Articulación del exoesqueleto (como en el parcial 2 de 2025-26).
 */
public class Node {

    private String name;
    private List<Segment> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Segment seg) {
        this.children.add(seg);
    }

    public String getName() {
        return this.name;
    }

    public List<Segment> getChildren() {
        return this.children;
    }
}
