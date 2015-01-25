/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Check pig allows to check if the user has internet and if the address is correct
 * @author Thibault
 */
public class ConnectionCheck {
     /**
     * Check ping of the address
     * Useful to check if the address is correct
     * @param address Adddress to check the ping
     * @param timeOut Timeout
     * @param os OS of the system
     * @return true if ping ok, false elseif
     */
    public static boolean checkPing(String address, int timeOut, String os)
    {
        if(address.isEmpty()) return false;
        
        String cmd;
        
        if(os.equals("linux")) cmd = "ping " + address + " -W " + timeOut +  " -c 5";
        else cmd =  "ping " + address + " -w " + timeOut*1000;
        
        Runtime rt = Runtime.getRuntime();

        try
        {

            
            Process pr = rt.exec(cmd);

            BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            StringBuffer output = new StringBuffer();
            String line = "";			
            while ((line = reader.readLine())!= null) 
            {
                int pos = line.indexOf("%");
                if (pos >= 0) {
                    if(line.charAt(pos-1)=='0' && line.charAt(pos-2)==' ')
                    {
                        //No loss => ping ok
                        return true;
                    }
                }
                
		output.append(line).append("\n");
            }
        }
        catch(IOException exception) { 
            System.out.println(exception);
            return false; 
        }
        
        return false;
    }
}
