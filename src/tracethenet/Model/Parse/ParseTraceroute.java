/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet.Model.Parse;

import java.util.ArrayList;
import java.util.List;
import tracethenet.Model.Route.Route;
import tracethenet.Model.Route.RouteFail;
import tracethenet.Model.Route.RouteSuccessNewIP;
import tracethenet.Model.Route.RouteSuccessOldIP;

/**
 * Parse Traceroute class
 * @author Thibault
 */
public class ParseTraceroute {
    protected ArrayList<ArrayList<Route>> resultRoute;
    protected final ArrayList<String> input;
    protected ArrayList<String> list;
    
    /**
     * Constructor 
     * @param resultArray Array of String of result or traceroute 
     */
    public ParseTraceroute(ArrayList<String> resultArray) 
    {
        input = resultArray;
        resultRoute = new ArrayList<>();
        list = new ArrayList<>();
    }
    
    /**
     * Return IP
     * @param step Step of the IP (line)
     * @return The IP
     */
    public String getIP(int step)
    {
        if(resultRoute.size()>step && resultRoute.get(step).size()==3)
        {
            if(resultRoute.get(step).get(0) instanceof RouteSuccessNewIP)
                return ((RouteSuccessNewIP)resultRoute.get(step).get(0)).getIP();
            else if(resultRoute.get(step).get(1) instanceof RouteSuccessNewIP)
                return ((RouteSuccessNewIP)resultRoute.get(step).get(1)).getIP();
            else if(resultRoute.get(step).get(2) instanceof RouteSuccessNewIP)
                return ((RouteSuccessNewIP)resultRoute.get(step).get(2)).getIP();
            else return "";
        }
        return null;
    }
    
    public ArrayList<String> getAllIp(){
        ArrayList<String> l = new ArrayList();
        
        for (int step=0; step<resultRoute.size(); step++ ){
        if(resultRoute.size()>step && resultRoute.get(step).size()==3)
        {
            if(resultRoute.get(step).get(0) instanceof RouteSuccessNewIP)
                l.add(((RouteSuccessNewIP)resultRoute.get(step).get(0)).getIP());
            else if(resultRoute.get(step).get(1) instanceof RouteSuccessNewIP)
                l.add(((RouteSuccessNewIP)resultRoute.get(step).get(1)).getIP());
            else if(resultRoute.get(step).get(2) instanceof RouteSuccessNewIP)
                l.add(((RouteSuccessNewIP)resultRoute.get(step).get(2)).getIP());
            
        }
        }
        return l;
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
     * If a step of a route has failed
     * @param step The step (line)
     * @param number wich oof the three try ?
     * @return true if failed, false else if
     */
    public boolean hasFailed(int step, int number)
    {
        return resultRoute.get(step).get(number) instanceof RouteFail;
    }
    
    /**
     * All three of route failed ?
     * @param step The step of traceroute
     * @return true if all failed, false else is
     */
    public boolean allFailed(int step)
    {
        return resultRoute.get(step).get(0) instanceof RouteFail && 
                resultRoute.get(step).get(1) instanceof RouteFail &&
                resultRoute.get(step).get(2) instanceof RouteFail;
    }
    
    /**
     * Parse finction whcih will be overidden foor Linux an Windows
     * @return True if no erreir, false if error occured
     */
    public boolean parse()
    {
        
        return true;
    }
    
    public ArrayList<String> getList(){
        return list;
    }
}
