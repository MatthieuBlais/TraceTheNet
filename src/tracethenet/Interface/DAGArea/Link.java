/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.DAGArea;

/**
 *
 * @author Matthieu Blais
 */
public class Link {

    private Node n1;
    private Node n2;
    private int cycle;

    public Link(Node n1, Node n2, int cycle) {
        this.n1 = n1; 
        this.n2 = n2;
        this.cycle = cycle;
    }

    @Override
    public String toString() { // Always good for debugging
        return "Node : " + n1.toString() + " " + n2.toString();
    }
    
    public Node getFirstNode(){
    return n1;
    }
    
    public Node getSecondNode(){
        return n2;
    }

    public String getCycle(){
        return Integer.toString(cycle)+")";
    }
}
