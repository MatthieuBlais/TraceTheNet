/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import tracethenet.Interface.InteractionArea.TracePanel;
import tracethenet.Model.Route.TraceRoute;

/**
 *
 * @author Matthieu Blais
 */
public class ProgressThread extends SwingWorker < Void , Void >{

    private Frame window;
    private JDialog dlg;
    private boolean aff;
    private JProgressBar dpb;
    private TracePanel tt;
        private String s;
        private ArrayList<String> l;

    public ProgressThread(Frame window, String ss, TracePanel tp) {
        this.window = window;
       // dlg = new JDialog(window, "Traceroute", true);
        dpb = new JProgressBar(JProgressBar.HORIZONTAL);
        dpb.setIndeterminate(true);
        dpb.setSize(new Dimension(150,50));
        dpb.setPreferredSize(new Dimension(150,50));
        dpb.setStringPainted(true);
        dpb.setString("Traceroute in progress");
      /*  dlg.add(BorderLayout.CENTER, dpb);
        dlg.add(BorderLayout.NORTH, new JLabel("Traceroute in progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(window);
        dlg.setResizable(false);*/
        window.add(dpb, BorderLayout.SOUTH);
        dpb.setVisible(false);
        aff = false;
        s = ss;
        tt = tp;
    }

    @Override
    protected Void doInBackground() throws Exception {
         setAff(true);

         l = new ArrayList<>();
          System.out.println("sss");
                    TraceRoute trace = new TraceRoute(s,tt.getSSH());
                    trace.setMaxHost(tt.getMax());
                    trace.setTimeOut(tt.getTimeout());
                    
                    if(trace.checkPing())
                    {
                    trace.execute();
                    trace.parse();
                    trace.printResult();
                    trace.printIP();
                    l = trace.getParseResult().getAllIp();
                    int nbResult = trace.getParseResult().getResultSize();
                    
                    }
                    else{
                    l.add(s);
                    }
             setAff(false);        
                    window.getPannel().getMainPanel().createGraph(l);
                    window.getPannel().getScroll().validate();
                    window.getPannel().getScroll().repaint();
        
         return null;
    }
    
    public void setAff(boolean v){
       dpb.setVisible(v);
    }
    
    public void setAff2(boolean v){
        aff = v;
    }

}
