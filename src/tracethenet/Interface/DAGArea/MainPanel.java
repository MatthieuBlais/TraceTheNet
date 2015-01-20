/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.DAGArea;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Matthieu Blais
 */
public class MainPanel extends JPanel{
    
    private BorderLayout layout;
    
    public MainPanel(){
        
        layout = new BorderLayout();
        setLayout(layout);
        setBackground(Color.WHITE);
        
        
    }
}
