package arboles;

/**
 * Segmento (hueso) del exoesqueleto, que termina en otra articulación.
 */
public class Segment {

    private double length;
    private Node endNode;

    public Segment(double length, Node endNode) {
        this.length = length;
        this.endNode = endNode;
    }

    public double getLength() {
        return this.length;
    }

    public Node getEndNode() {
        return this.endNode;
    }
}
