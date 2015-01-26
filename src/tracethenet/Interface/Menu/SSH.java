/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface.Menu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import tracethenet.Interface.Frame;
import tracethenet.Interface.InteractionArea.TracePanel;

/**
 *
 * @author Matthieu Blais
 */
public class SSH extends AbstractAction {
	private final Frame window;
       private TracePanel t; 
 
	public SSH(Frame window, String texte){
		super(texte);
 
		this.window = window;
                t = window.getPannel().getBtn();
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		JCheckBoxMenuItem j = (JCheckBoxMenuItem)e.getSource();
                if(j.isSelected())
                    t.setSSH(true);
                else
                    t.setSSH(false);
                    
	}
}

