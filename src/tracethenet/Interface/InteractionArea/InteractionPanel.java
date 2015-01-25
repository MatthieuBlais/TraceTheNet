/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.*;
import javax.swing.*;
import tracethenet.Interface.DAGArea.GraphDAG;
import tracethenet.Interface.DAGArea.MainPanel;

/**
 *
 * @author Matthieu Blais
 */
public class InteractionPanel extends JPanel{
    
    private GridLayout layout;
    private HostnamePanel host;
    
    
    public InteractionPanel(MainPanel graph, JScrollPane scroll, Frame window){
        
        layout = new GridLayout(0,1);
        setLayout(layout);
        setBackground(new Color(0,0,0,0));
        host = new HostnamePanel();
        
        add(host);
        add(new TracePanel(graph, scroll, host, window));

        
    }
    
    
}
