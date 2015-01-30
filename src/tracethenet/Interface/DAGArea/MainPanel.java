/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.DAGArea;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Matthieu Blais
 */
public class MainPanel extends JPanel{
    
    private FlowLayout layout;
    private GraphDAG graph;
    private ArrayList<String> str;
    
    public MainPanel(){
        graph = new GraphDAG();
        layout = new FlowLayout();
        setLayout(layout);
        setBackground(Color.WHITE);/*
        str = new ArrayList<String>();
        str.add("125");
        str.add("456");
        str.add("789");
        str.add("147");
        str.add("258");
        str.add("369");
        str.add("123");

        createGraph(str);
        str.clear();
        str.add("783");
        str.add("143");
        str.add("253");

        
       
        createGraph(str);*/
    }
    
    public void clear(){
        removeAll();
    }
    
    public void createGraph(ArrayList<String> liste){
        clear();
        add(graph.constructGraph(liste,0,liste.size()));
        validate();
        repaint();
    }
    
    public GraphDAG getGraph(){
        return graph;
    }
}
