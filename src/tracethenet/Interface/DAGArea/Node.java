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
public class Node {

    private final int id;
    private final String IP;

    public Node(int id, String s) {
        this.id = id;
        this.IP = s;
    }

    public String toString() { 
        return IP; 
    }    

}
