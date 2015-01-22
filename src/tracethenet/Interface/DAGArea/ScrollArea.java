/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.DAGArea;

import javax.swing.JScrollPane;

/**
 *
 * @author Matthieu Blais
 */
public class ScrollArea{
    
    private MainPanel panel;
    private JScrollPane scroll;
    
    public ScrollArea(){
        panel = new MainPanel();
        scroll = new JScrollPane(panel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    public JScrollPane getScroll(){
        return scroll;
    }
    
    public void clear(){
        
    }
    
    public MainPanel getGraph(){
        return panel;
    }
}
