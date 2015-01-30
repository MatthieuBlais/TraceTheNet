/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import tracethenet.Model.Route.TraceRoute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tracethenet.Interface.Frame;
import tracethenet.Interface.ProgressThread;

/**
 * Main class of the program.
 * Contain the main
 * @author matt
 */
public class TraceTheNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //try {
            // TODO code application logic here
            //CheckPing : check if the website exits and if we have internet
            Frame window = new Frame();
            /* ProgressThread t = new ProgressThread(window);
            t.start();*/
            
            //  TraceRoute trace = new TraceRoute("google.fr", true);
            
            /* How to use Traceroute
            trace.getParseResult().getResultSize() : return number of line
            trace.getParseResult().allFailed(step) : Il all route of the line step failed
            trace.getParseResult().hasFailed(step, number) : If a route of the step line has failed
            trace.getParseResult().getIP(step); : Give IP of the line step
            trace.getParseResult().gethostname(step); : Give hostname of the line step
            trace.getParseResult().getTime(step, number) : Get time of the step line and the try number
            */
            /*
            
            if(trace.checkPing())
            {
            trace.execute();
            trace.parse();
            for(int i=0; i<trace.getParseResult().getResultSize(); i++){
            System.out.println(trace.getParseResult().getIP(i) );
            }
            trace.printResult();
            //trace.printIP();
            ArrayList<String> l = trace.getParseResult().getAllIp();
            for(int i=0; i<l.size(); i++)
            System.out.println(l.get(i));
            int nbResult = trace.getParseResult().getResultSize();
            }*/
            //t.stopp();
            
            /* } catch (IOException ex) {
            Logger.getLogger(TraceTheNet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (IOException ex) {
            Logger.getLogger(TraceTheNet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
