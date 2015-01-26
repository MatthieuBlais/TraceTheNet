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
     private int max;
        private boolean ssh;
        private int timeout;
     
     public TracePanel(MainPanel graph, JScrollPane scroll, HostnamePanel host, Frame window){
         max = 255;
                ssh =false;
                timeout = 5;
        Layout = new FlowLayout();
        this.host = host;
        setLayout(Layout);
        setBackground(new Color(0,0,0,30));
        
        btn = new JButton(new TraceAction(window, "Trace the route", this.host, this));
        add(btn);
        clean = new JButton(new CleanAction("Clean", graph,scroll));
        add(clean);
        
     }
     
     public TracePanel getBtn(){
         return this;
     }
     
     public void setMax(int m){
            max = m;
        }
        
        public void setTimeout(int t){
            timeout = t;
        }
        
        public void setSSH(boolean t){
            ssh = t;
        }
        
        public int getTimeout(){
            return timeout;
        }
    
        public int getMax(){
            return max;
        }
        
        public boolean getSSH(){
            return ssh;
        }
                
    
}
