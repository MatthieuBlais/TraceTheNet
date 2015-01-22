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
		JOptionPane.showMessageDialog(window,
                        "Do you want some help?\n\n"
                                + "Random : Generate a random IP\n"
                                + "Clean : Start a new graph\n"
                                + "Trace the route : Trace the graph\n"
                                + "Timeout : Configure a timeout for the traceroute function\n"
                                + "Max Hosts : Configure a maximal number of host\n"
                                + "Linux/Windows : Make the choice of your OS\n"
                                + "SSH : Trace the route with a SSH server. Very useful at ECE\n"
                                + "Save : Save the graph as a jpg file\n"
                                + "Load : Load a text file with one IP number on each line\n\n");
	}
}
