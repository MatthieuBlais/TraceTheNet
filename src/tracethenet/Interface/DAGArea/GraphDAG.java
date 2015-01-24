/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.DAGArea;


import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.DAGLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Matthieu Blais
 */
public class GraphDAG {

    private Graph<Node, Link> g;
    private ArrayList<Node> node;
    private ArrayList<Link> link;
    private int counter;
    private JPanel panel;
    private int cycle;
    
    public GraphDAG() {
        g = new  DirectedSparseGraph<Node, Link>();
        node = new ArrayList<Node>();
        link = new ArrayList<Link>();
        counter = 0;
        cycle = 0;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(50, 50, 50, 50) );
    }

    public JPanel constructGraph(ArrayList<String> list, int a) {
        addBranch(list);
        Layout<Node, Link> layout;
        if (a==0)
           layout  = new ISOMLayout<>(g);
        else
            layout = new CircleLayout<>(g);
            
        VisualizationViewer<Node, Link> vv = new VisualizationViewer<Node, Link>(layout);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
       // vv.setBorder(new EmptyBorder(100, 100, 100, 100));
        
        vv.setBackground(Color.WHITE);
        
        panel.removeAll();
        panel.setBackground(Color.WHITE);
        panel.add(vv);
        return panel;
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public boolean isNodeExist(Node nd){
        Node tmp;
        for(int i=0; i<node.size(); i++){
            tmp = node.get(i);
            if(tmp.toString().equals(nd.toString()))
                return true;
        }
        return false;
    }
    
    public Node getNodeExist(Node nd){
        Node tmp;
        for(int i=0; i<node.size(); i++){
            tmp = node.get(i);
            if(tmp.toString().equals(nd.toString()))
                return tmp;
        }
        return nd;
    }
    
    public boolean isLinkExist(Link lk){
        Link tmp;
        for (int i=0; i<link.size(); i++){
            tmp = link.get(i);
            if(tmp.toString().equals(lk.toString()))
                return true;
        }
        return false;
    }
    
    
    public boolean addEdge(String ip1, String ip2){
        Node nd1 = new Node(counter, ip1);
        Node nd2 = new Node(counter+1,ip2);
        counter+=2;
        Link lk = new Link(nd1, nd2,cycle);
        if (isLinkExist(lk))
            return false;
        else{
            if(isNodeExist(nd1))
                nd1 = getNodeExist(nd1);
            else
                node.add(nd1);
            
            if(isNodeExist(nd2))
                nd2 = getNodeExist(nd2);
            else
                node.add(nd2);
            
            link.add(lk);
            
            g.addEdge(lk, nd1, nd2);
            return true;
        }
        
    }
    
    public void addBranch(ArrayList<String> list){
        for (int i=0; i<(list.size()-1); i++){
            addEdge(list.get(i), list.get(i+1));
            
        }
        cycle++;
    }
    
    public void clearGraph(){
        node.clear();
        link.clear();
        counter = 0;
        cycle = 0;
        g = new  DirectedSparseGraph<Node, Link>();
    }
    
    public ArrayList<Link> getAllLink(){
        return link;
    }
    

}
