/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

/**
 *
 * @author matt
 */
public class TraceTheNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //CheckPing : check if the website exits and if we have internet
        TraceRoute trace = new TraceRoute("google.fr", true);
        if(trace.checkPing())
        {
            trace.execute();
            trace.printResult();
        }

        
    }
    
}
