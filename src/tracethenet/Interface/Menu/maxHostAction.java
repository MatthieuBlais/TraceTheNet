/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.Menu;

import java.awt.event.ActionEvent;
import javax.swing.*;
import tracethenet.Interface.Frame;
import tracethenet.Interface.InteractionArea.TracePanel;

/**
 *
 * @author Matthieu Blais
 */
public class maxHostAction extends AbstractAction {
	private final Frame window;
        private int max;
        private TracePanel t; 
 
	public maxHostAction(Frame window, String texte){
		super(texte);
                max = 255;
		this.window = window;
                t = window.getPannel().getBtn();
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		
            String name = JOptionPane.showInputDialog(window,
                        "Specify the maximum reachable hosts (0-255): ", null);
                 System.out.println(name);
               
                 if(name!=null){
                 if(name.isEmpty())
                    max = 20;
                else
                    max = Integer.parseInt(name);
                System.out.println(max);
                if(max<0)
                    t.setMax(0);
                else if(max>255)
                    t.setMax(20);
                else
                     t.setMax(max);
                
                System.out.println(t.getMax());
                 }
                 else
                     t.setMax(20);
	}
        
        
}
