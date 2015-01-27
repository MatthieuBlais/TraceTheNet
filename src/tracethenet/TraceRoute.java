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
 * Manage traceroute command
 * @author Thibault
 */
public class TraceRoute {
    
    private ArrayList<String> resultArray;
    private String address;
    private boolean ssh;
    private final SSH sshObject;
    private boolean ping;
    private ParseTraceroute parseResult;
    private int timeOut;
    private int maxHost;
    private final String os;
    
    /**
     * Constructor
     * @param addressTmp Address choosen
     * @param sshh Boolean if SSH needed
     */
    public TraceRoute (String addressTmp, boolean sshh)
    {
        address = addressTmp;
        ssh = sshh;
        ping = false;
        sshObject = new SSH("195.154.68.197", "thibault", "sarazasaraza");
        maxHost = 255;
        timeOut = 5;//In seconds
        if("windows".equals(OS.getOperatingSystemType()))
            os = "windows";
        else os = "linux";
    }
    
    /**
     * Get the traceroute command because it depends of the OS
     * @return the traceroute command
     */
    public String getTracerouteCmd()
    {
        if(!"windows".equals(OS.getOperatingSystemType()) || ssh) return "traceroute " + address + " -m " + maxHost + " -w " + timeOut;
        else return "tracert "  + "-h " + maxHost + " -w " + timeOut*1000 + " " + address;
    }
    
    /**
     * Execute the traceroute but in SSH
     * @return true if okay, false if error occured
     */
    public boolean executeSSH()
    {
        if(!ping)
        {
            if(!sshObject.checkServer(timeOut, os)) return false;
        }
        resultArray = sshObject.executeCmd(getTracerouteCmd());
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
            ping = sshObject.checkServer(timeOut, os);
        else
        {
            ping = ConnectionCheck.checkPing("google.fr", timeOut, os);
        }
            
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
            if(!ConnectionCheck.checkPing("google.fr", timeOut, os))
            {
                System.out.println("No ping, Do you have Internet ? Or maybe Google is down...");
                return false;
            }
        }

        Runtime rt = Runtime.getRuntime();
        try
        {
            Process pr = rt.exec(getTracerouteCmd());
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            resultArray = new ArrayList<>();
            while ((line = reader.readLine())!= null) 
            {
                resultArray.add(line);
            }
        }
        catch(IOException exception) 
        { 
            System.out.println(exception);
            return false; 
        }
        return true;
    }
    
    /**
     * Parse the result of the traceroute cmd
     * @return false if error occured, true if no error
     */
    public boolean parse()
    {
        if("windows".equals(OS.getOperatingSystemType()) && !ssh)
            parseResult = new ParseTracerouteWindows(resultArray);
        else 
            parseResult = new ParseTracerouteLinux(resultArray);
         
        return parseResult.parse();
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
        for (String resultArray1 : resultArray) {
            System.out.println(resultArray1);
        }
    }
    
    public void printIP(){
        ArrayList<String> l = parseResult.getList();
        for (int i=0; i<l.size(); i++){
            System.out.println(l.get(i));
        }
    }
    
    public ArrayList<String> getListIP(){
        return parseResult.getList();
    }
    
    /**
     * Get parse result
     * @return The ParseTraceroute object
     */
    public ParseTraceroute getParseResult()
    {
        return parseResult;
    }
    
    /**
     * Set timeOut
     * @param time the timeout 
     */
    public void setTimeOut(int time)
    {
        timeOut = time;
    }
    
    /**
     * Set Max host
     * @param max the number of host max
     */
    public void setMaxHost(int max)
    {
        if(max>255 || max <0)
            max = 255;
        maxHost = max;
    }
}
