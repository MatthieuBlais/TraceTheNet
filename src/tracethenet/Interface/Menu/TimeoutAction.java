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
public class TimeoutAction extends AbstractAction {
	private final Frame window;
        private int timeout;
        private TracePanel t; 
 
	public TimeoutAction(Frame window, String texte){
		super(texte);
 
		this.window = window;
                 t = window.getPannel().getBtn();
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
            String name ="";
            name = JOptionPane.showInputDialog(window,
                        "Specify the timeout (0-60): ", null);
                 System.out.println(name);
                
                if(name.isEmpty())
                    timeout = 10;
                else
                    timeout = Integer.parseInt(name);
                
                if(timeout<0)
                    t.setTimeout(0);
                else if(timeout>60)
                    t.setTimeout(60);
                else
                    t.setTimeout(timeout);
                
                System.out.println(t.getTimeout());
	}
}