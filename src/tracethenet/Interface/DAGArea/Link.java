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

    Node n1;
    Node n2;

    public Link(Node n1, Node n2) {
        this.n1 = n1; 
        this.n2 = n2;
    }

    @Override
    public String toString() { // Always good for debugging
        return "Node : " + n1.toString() + " " + n2.toString();
    }

}
