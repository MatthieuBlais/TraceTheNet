/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import tracethenet.Interface.DAGArea.GraphDAG;
import tracethenet.Interface.DAGArea.MainPanel;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class TracePanel extends JPanel{
    
     private FlowLayout Layout;
     private JButton btn;
     private JButton clean;
     private HostnamePanel host;
     
     public TracePanel(MainPanel graph, JScrollPane scroll, HostnamePanel host, Frame window){
        Layout = new FlowLayout();
        this.host = host;
        setLayout(Layout);
        setBackground(new Color(0,0,0,30));
        
        btn = new JButton(new TraceAction(window, "Trace the route", this.host));
        add(btn);
        clean = new JButton(new CleanAction("Clean", graph,scroll));
        add(clean);
     }
    
    
}
