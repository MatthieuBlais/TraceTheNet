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
 *
 * @author Thibault
 */
public class ConnectionCheck {
     /**
     * Check ping of the address
     * Useful to check if the address is correct
     * @param address Adddress to check the ping
     * @return true if ping ok, false elseif
     */
    public static boolean checkPing(String address)
    {
        if(address.isEmpty()) return false;
        
        Runtime rt = Runtime.getRuntime();
        String ping;
        try
        {
            if(!OS.getOperatingSystemType().equals("windows"))
                ping = "ping " + address;
            else
                ping = "ping -c 5 " + address;
            
            Process pr = rt.exec("ping "+address);

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
