/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tracethenet.Interface.Frame;

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
        // TODO code application logic here
        try {
            // TODO code application logic here
            //CheckPing : check if the website exits and if we have internet
       /* TraceRoute trace = new TraceRoute("google.fr", true);
        if(trace.checkPing())
        {
            trace.execute();
            trace.printResult();
            trace.parse();
            int nbResult = trace.getParseResult().getResultSize();
        }*/
            Frame window = new Frame();
        } catch (IOException ex) {
            Logger.getLogger(TraceTheNet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
