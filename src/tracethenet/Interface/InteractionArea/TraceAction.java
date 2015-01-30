/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tracethenet.Interface.InteractionArea;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import tracethenet.Interface.Frame;
import tracethenet.Interface.ProgressThread;
import tracethenet.Model.Route.TraceRoute;

/**
 *
 * @author Matthieu Blais
 */
public class TraceAction extends AbstractAction {
 
        private HostnamePanel host;
        private Frame window;
        private TracePanel tt;
        private String s;
        private ArrayList<String> l;
    
	public TraceAction(Frame window, String texte, HostnamePanel host, TracePanel t){
		super(texte);
                this.host = host;
                this.window = window;
                this.tt=t;   
                
	}
 
        @Override
	public void actionPerformed(ActionEvent e) {
            JTextField text = host.getTextField();
            l = new ArrayList<>();
            s = text.getText();
            
            if(s.equals("") || s == null){
                JOptionPane.showMessageDialog(window,"Error in IP adress. Please try again.",
                "Extension error",
                JOptionPane.ERROR_MESSAGE);
            }
            else{
               
              /*   ProgressThread tache = new ProgressThread(window);
                tache.setAff(true);
            tache.execute();*/
            //    JProgressBar bar = new JProgressBar ();
ProgressThread worker = new ProgressThread (window, s, tt);
        worker.execute();
                try {
                    
                 //   worker.setAff2(false);
                    Thread.sleep(25);
//window.add(bar);
                    /*
                    
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
                    
                    
                    
                    
                    //       try {
                    //         ProgressThread t = new ProgressThread(window);
                    //    t.start();
                    //  while(t.isAlive())
                    //    tache.setVisible(true);
                    System.out.println("aaa");
                    
                    
                    window.getPannel().getMainPanel().createGraph(l);
                    window.getPannel().getScroll().validate();
                    window.getPannel().getScroll().repaint();
                    
                    //    tache.setAff(false);
                    
                    
                    System.out.println("bbb");*/
                    //} catch (InterruptedException ex) {
                    //    Logger.getLogger(TraceAction.class.getName()).log(Level.SEVERE, null, ex);
                    // }
                } catch (InterruptedException ex) {
                    Logger.getLogger(TraceAction.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        
            
        
            }
		
	}
        
        
}
