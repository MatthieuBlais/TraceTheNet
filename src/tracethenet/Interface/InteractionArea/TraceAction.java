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
        
    
	public TraceAction(Frame window, String texte, HostnamePanel host, TracePanel t){
		super(texte);
                this.host = host;
                this.window = window;
                this.tt=t;   
                
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
            else{
        //         ProgressThread t = new ProgressThread(window);
       //    t.start();
             
        TraceRoute trace = new TraceRoute(s,tt.getSSH());
        trace.setMaxHost(tt.getMax());
        trace.setTimeOut(tt.getTimeout());

        if(trace.checkPing())
        {
            trace.execute();
            trace.parse();
            trace.printResult();
            trace.printIP();
            
            int nbResult = trace.getParseResult().getResultSize();
        }
        
        
         window.getPannel().getMainPanel().createGraph(trace.getListIP());
        window.getPannel().getScroll().validate();
        window.getPannel().getScroll().repaint();
                
        
        //t.stopp();
            }
		
	}
        
        
}
