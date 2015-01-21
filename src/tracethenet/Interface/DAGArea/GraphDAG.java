/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.DAGArea;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

/**
 *
 * @author Matthieu Blais
 */
public class GraphDAG {

    private Graph<Node, Link> g;
    //List node
    //Liste linj
    
    
    public GraphDAG() {

    }

    public void constructGraph() {
        g = new  SparseMultigraph<Node, Link>();
        // Create some MyNode objects to use as vertices
       /* n1 = new MyNode(1);
        n2 = new MyNode(2);
        n3 = new MyNode(3);
        n4 = new MyNode(4);
        n5 = new MyNode(5); // note n1-n5 declared elsewhere.
        // Add some directed edges along with the vertices to the graph
        g.addEdge(new MyLink(2.0, 48), n1, n2, EdgeType.DIRECTED); // This method
        g.addEdge(new MyLink(2.0, 48), n2, n3, EdgeType.DIRECTED);
        g.addEdge(new MyLink(3.0, 192), n3, n5, EdgeType.DIRECTED);
        g.addEdge(new MyLink(2.0, 48), n5, n4, EdgeType.DIRECTED); // or we can use
        g.addEdge(new MyLink(2.0, 48), n4, n2); // In a directed graph the
        g.addEdge(new MyLink(2.0, 48), n3, n1); // first node is the source 
        g.addEdge(new MyLink(10.0, 48), n2, n5);// and the second the destination*/
    }
    
    //if node already exist, return node
    
    //if link already exist, return false
    
    //recoit tableau IP, pour taille tableau
    //                  vérifie si lien exist : vrai on passe au prochain, faux 
    //                                  vérifie si le noeud 1 existe. Si oui get node, si non créer node
    //                                  verifie si noeud 2 existe. Si oui, get node, si non créer node
    //                                  creation lien
    //                                  addEdge
    //                                  addList node
    //                                  add link
    

}
