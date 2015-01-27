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
import javax.swing.SwingWorker;

/**
 *
 * @author Matthieu Blais
 */
public class ProgressThread extends SwingWorker < Void , Void >{

    private Frame window;
    private JDialog dlg;
    private boolean aff;

    public ProgressThread(Frame window) {
        this.window = window;
        dlg = new JDialog(window, "Traceroute", true);
        JProgressBar dpb = new JProgressBar(JProgressBar.HORIZONTAL);
        dpb.setIndeterminate(false);
        dlg.add(BorderLayout.CENTER, dpb);
        dlg.add(BorderLayout.NORTH, new JLabel("Traceroute in progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(window);
        dlg.setResizable(false);
        aff = false;
    }

    @Override
    protected Void doInBackground() throws Exception {
         for (int k = 0; k < 1000 ; k ++) {
setProgress ( k );
Thread.sleep (250);
}
return null;

    }
    
    public void setAff(boolean v){
        aff = v;
    }

}
