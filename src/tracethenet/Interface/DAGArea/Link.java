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

    int id;

    public Link(int id) {
        this.id = id; // This is defined in the outer class.
    }

    public String toString() { // Always good for debugging
        return "Node : " + id;
    }

}
