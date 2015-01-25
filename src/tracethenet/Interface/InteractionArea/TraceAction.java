/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class TraceAction extends AbstractAction {
 
        private HostnamePanel host;
        private Frame window;
    
	public TraceAction(Frame window, String texte, HostnamePanel host){
		super(texte);
                this.host = host;
                this.window = window;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) {
            JTextField text = host.getTextField();
            
            String s = text.getText();
            
            if(s.equals("") || s == null){
                JOptionPane.showMessageDialog(window,"Error in IP adress. Please try again.",
    "Extension error",
    JOptionPane.ERROR_MESSAGE);
            }
            
		
	}
}
