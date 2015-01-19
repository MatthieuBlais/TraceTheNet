/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import java.util.ArrayList;

/**
 * Parse Traceroute class
 * @author Thibault
 */
public class ParseTraceroute {
    protected ArrayList<ArrayList<Route>> resultRoute;
    protected final ArrayList<String> input;
    
    /**
     * Constructor 
     * @param resultArray Array of String of result or traceroute 
     */
    public ParseTraceroute(ArrayList<String> resultArray) 
    {
        input = resultArray;
        resultRoute = new ArrayList<>();
    }
    
    /**
     * Return IP
     * @param step Step of the IP (line)
     * @return The IP
     */
    public String getIP(int step)
    {
        if(resultRoute.get(step).get(0) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(0)).getIP();
        else if(resultRoute.get(step).get(1) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(1)).getIP();
        else if(resultRoute.get(step).get(2) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(2)).getIP();
        else return "";
    }

    /**
     * Return the hostnmae
     * @param step The step (line) of the need hostname
     * @return "" if no hostname, the hostname else is
     */
    public String getHostname(int step)
    {
        if(resultRoute.get(step).get(0) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(0)).getHostname();
        else if(resultRoute.get(step).get(1) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(1)).getHostname();
        else if(resultRoute.get(step).get(2) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(2)).getHostname();
        else return "";
    }

    /**
     * Get time 
     * @param step The step (line) needed
     * @param number There are 3 time so which onee ?
     * @return The time
     */
    public String getTime (int step, int number)
    {
        if(resultRoute.get(step).get(number) instanceof RouteSuccessNewIP)
            return ((RouteSuccessNewIP)resultRoute.get(step).get(number)).getTime();
        else if(resultRoute.get(step).get(number) instanceof RouteSuccessOldIP)
            return ((RouteSuccessOldIP)resultRoute.get(step).get(number)).getTime();
        else return "";
    }
    
    /**
     * Get number of lines
     * @return The numbre of lines
     */
    public int getResultSize()
    {
        return resultRoute.size();
    }
    
    /**
     * Parse finction whcih will be overidden foor Linux an Windows
     * @return True if no erreir, false if error occured
     */
    public boolean parse()
    {
        
        return true;
    }
}
