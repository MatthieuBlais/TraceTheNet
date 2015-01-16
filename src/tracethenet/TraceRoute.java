/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Thibault
 */
public class TraceRoute {
    
    private String result;
    ArrayList<Route> retour;
    private String address;
    private boolean ssh;
    private SSH sshObject;
    private boolean ping;
    
    public TraceRoute (String addressTmp, boolean sshh)
    {
        address = addressTmp;
        ssh = sshh;
        ping = false;
        sshObject = new SSH("195.154.68.197", "thibault", "sarazasaraza");
    }
    
    /**
     * Get the traceroute command because it depends of the OS
     * @return the traceroute command
     */
    public String getTracerouteCmd()
    {
        if("windows".equals(OS.getOperatingSystemType())) return "tracert";
        else return "traceroute";
    }
    
    /**
     * Execute the traceroute but in SSH
     */
    public boolean executeSSH()
    {
       
        if(!ping)
        {
            if(!sshObject.checkServer()) return false;
        }
        
        result = sshObject.executeCmd("traceroute " + address);
        sshObject.closeSSH();
        return true;
    }
    
    /**
     * Check ping of the current address
     * @return true if okay, false elseif
     */
    public boolean checkPing()
    {
        if(ssh)
            ping = sshObject.checkServer();
        else
            ping = ConnectionCheck.checkPing(address);
        return ping;
    }
    
    /**
     * Execute the traceroute
     * @return 
     */
    public boolean execute()
    {
        if(address.isEmpty()) return false;
        
        if(ssh) 
        {
            //If problem with SSH connection, we will use the standard connection
            if(executeSSH())
                return true;
            System.out.println("Problem with SSH, try with standard connection");
        }
        
        if(!ping)
        {
            if(!ConnectionCheck.checkPing(address))
            {
                System.out.println("No ping, Do you have Internet ?");
                return false;
            }
        }

        StringBuffer output = new StringBuffer();
        Runtime rt = Runtime.getRuntime();
        try
        {
            Process pr = rt.exec(getTracerouteCmd() + " " + address);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;			
            while ((line = reader.readLine())!= null) 
            {
		output.append(line).append("\n");
            }
        }
        catch(IOException exception) 
        { 
            System.out.println(exception);
            return false; 
        }
        
        result = output.toString();
        
        return true;
    }
    
    /**
     * Parse the result of the traceroute cmd
     * @return an arrayList with all route in an arraylist
     */
    public ArrayList<Route> parse()
    {
       retour = new ArrayList<>();
       return retour;
    }
    
    /**
     * Set ssh booean
     * @param value New value for SSH
     */
    public void setSSH(boolean value)
    {
        ssh = value;
    }
    
    /**
     * Set a new address
     * @param newAddress the new address
     */
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    
    /**
     * print content of result
     */
    public void printResult()
    {
        System.out.println(result);
    }
}
