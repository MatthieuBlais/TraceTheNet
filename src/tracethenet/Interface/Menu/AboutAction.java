/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.Menu;

import java.awt.event.ActionEvent;
import javax.swing.*;
import tracethenet.Interface.Frame;

/**
 *
 * @author Matthieu Blais
 */
public class AboutAction extends AbstractAction {
	private final Frame window;
 
	public AboutAction(Frame window, String texte){
		super(texte);
 
		this.window = window;
	}
 
        @Override
	public void actionPerformed(ActionEvent e) { 
		
	}
}
