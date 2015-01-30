/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;
import tracethenet.Interface.Frame;
import tracethenet.Model.GenerateIP.GenerateIP;

/**
 *
 * @author Matthieu Blais
 */
public class RandomIpAction extends AbstractAction {
	
        private JTextField j;
    
	public RandomIpAction(String texte, JTextField jj){
		super(texte);
                j = jj;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		GenerateIP g = new GenerateIP();
                j.setText(g.generate());
                
	}
}