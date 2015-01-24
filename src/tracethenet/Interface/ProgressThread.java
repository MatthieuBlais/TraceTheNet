/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Matthieu Blais
 */
public class ProgressThread extends Thread {

    private Frame window;
    private JDialog dlg;

    public ProgressThread(Frame window) {
        this.window = window;
        dlg = new JDialog(window, "Traceroute", true);
        JProgressBar dpb = new JProgressBar(JProgressBar.HORIZONTAL);
        dpb.setIndeterminate(true);
        dlg.add(BorderLayout.CENTER, dpb);
        dlg.add(BorderLayout.NORTH, new JLabel("Traceroute in progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(window);
        dlg.setResizable(false);
    }

    @Override
    public void run() {
        dlg.setVisible(true); 
        
    }

    public void stopp(){
        dlg.setVisible(false);
    }
}
