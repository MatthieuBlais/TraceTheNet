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
public class ScrollArea extends JScrollPane{
    
    public ScrollArea(){
        super(new MainPanel());
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    public void clear(){
        
    }
}
